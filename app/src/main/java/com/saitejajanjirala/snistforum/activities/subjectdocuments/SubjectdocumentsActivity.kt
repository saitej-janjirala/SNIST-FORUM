package com.saitejajanjirala.snistforum.activities.subjectdocuments

import android.Manifest
import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.saitejajanjirala.snistforum.BuildConfig
import com.saitejajanjirala.snistforum.MyApplication
import com.saitejajanjirala.snistforum.R
import com.saitejajanjirala.snistforum.adapter.DocumentAdpater
import com.saitejajanjirala.snistforum.base.ViewModelProviderFactory
import com.saitejajanjirala.snistforum.models.Document
import com.saitejajanjirala.snistforum.models.FirebaseDocumentFile
import com.saitejajanjirala.snistforum.utils.Keys
import com.saitejajanjirala.snistforum.utils.Toaster
import java.io.File
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.reflect.typeOf


class SubjectdocumentsActivity : AppCompatActivity(), DocumentAdpater.OnDocumentItemClickListener {
    private lateinit var documentsRecyclerView: RecyclerView
    private lateinit var documentsAdapter: DocumentAdpater
    private lateinit var emptyLayout: RelativeLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var documentsList: ArrayList<FirebaseDocumentFile>
    private lateinit var subjectName: String
    private lateinit var subjectDocumentViewModel: SubjectDocumentViewModel
    private lateinit var timer:Timer
    private lateinit var selectedDocuments:ArrayList<Document>
    val mimeTypes = arrayOf(
        "application/vnd.ms-powerpoint",
        "application/pdf",
        "application/msword",
        "application/vnd.openxmlformats-officedocument.presentationml.presentation",
        "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
    )
    val fileExtensionMap=HashMap<String,String>()
    private var from=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subjectdocuments)
        intent.getStringExtra("subject")?.let {
            subjectName = it
        }
        intent.getStringExtra("from")?.let {
            from=it
        }
        supportActionBar?.title = "$subjectName"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initView()
        setUpViewModel()
        setUpListeners()
        documentsList = ArrayList()
        selectedDocuments=ArrayList()
        documentsAdapter = DocumentAdpater(
            this,
            selectedDocuments,
            from,
            documentsList,
            this
        )
        documentsRecyclerView.adapter = documentsAdapter
        fileExtensionMap[mimeTypes[0]]=".ppt"
        fileExtensionMap[mimeTypes[1]]=".pdf"
        fileExtensionMap[mimeTypes[2]]=".msword"
        fileExtensionMap[mimeTypes[3]]=".pptx"
        fileExtensionMap[mimeTypes[4]]=".wordx"
        fetchData()
    }

    private fun initView() {
        documentsRecyclerView = findViewById(R.id.documents_recyclerview)
        emptyLayout = findViewById(R.id.empty_layout)
        progressBar = findViewById(R.id.progress_bar)
    }

    private fun setUpViewModel() {
        val app = application as MyApplication
        subjectDocumentViewModel = ViewModelProviders.of(
            this,
            ViewModelProviderFactory(
                app.getSharedPrefInstance(),
                app.getCompositeDisposable(),
                app.getDatabaseService()
            )
        ).get(SubjectDocumentViewModel::class.java)
    }

    private fun setUpListeners() {
        subjectDocumentViewModel.isLoading.observe(this, Observer {
            if (it != null) {
                if (it) {
                    progressBar.visibility = View.VISIBLE
                } else {
                    progressBar.visibility = View.GONE
                }
            }
        })
        subjectDocumentViewModel.message.observe(this, Observer {
            Toaster.show(this, "$it")
        })
        subjectDocumentViewModel.DownloadedFilesList.observe(this, Observer {
            if(it!=null){
                for(i in it){
                    dumpImageMetaData(Uri.fromFile(i))
                }
                documentsAdapter.notifyDataSetChanged()
            }
            if(selectedDocuments.size==0){
                emptyLayout.visibility=View.VISIBLE
            }
            else{
                emptyLayout.visibility=View.GONE
            }
        })
    }

    fun fetchData() {
        if(from=="download") {
            val file=File("${Keys.DOWNLOADS_FOLDER_PATH}/$subjectName")
            file.listFiles()?.let {
                for(i in it) {
                    var uri=Uri.fromFile(file)
                    uri = FileProvider.getUriForFile(
                        this,
                        BuildConfig.APPLICATION_ID.toString() + ".provider",
                        i
                    )
                    grantUriPermission(
                        BuildConfig.APPLICATION_ID + ".provider",
                        uri, Intent.FLAG_GRANT_READ_URI_PERMISSION
                    )
                    val type=contentResolver.getType(uri)
                    if(type!=null) {
                        dumpImageMetaData(uri)
                    }

                }
                documentsAdapter.notifyDataSetChanged()
            }

        }
        else{
        val db = FirebaseFirestore.getInstance()
        subjectDocumentViewModel.isLoading.postValue(true)
        db.collection("subjects/$subjectName/documents")
            .whereEqualTo("deleted", false)
            .get()
            .addOnSuccessListener {
                val fbDocs = ArrayList<FirebaseDocumentFile>()
                for (i in it.documents) {
                    if (i.exists()) {
                        val obj = i.toObject(FirebaseDocumentFile::class.java)
                        if (obj != null) {
                            fbDocs.add(obj)
                        }
                    }
                }
                addtoList(fbDocs)
                subjectDocumentViewModel.isLoading.postValue(false)
            }
            .addOnFailureListener {
                subjectDocumentViewModel.isLoading.postValue(false)
                subjectDocumentViewModel.message.postValue(it.message)
            }
        }
    }

    fun addtoList(fbdocsList: ArrayList<FirebaseDocumentFile>) {
        documentsList.clear()
        documentsList.addAll(fbdocsList)
        if (documentsList.size == 0) {
            emptyLayout.visibility = View.VISIBLE
        } else {
            emptyLayout.visibility = View.GONE
        }
        documentsAdapter.notifyDataSetChanged()
    }

    override fun onSupportNavigateUp(): Boolean {
        super.onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onItemClicked(
        position: Int,
        document: Document,
        fbDocuemnt: FirebaseDocumentFile
    ) {
        if(from!="download") {
            val file = File(
                "${Keys.DOWNLOADS_FOLDER_PATH}/${fbDocuemnt.subjectname}/${fbDocuemnt.docname+ fileExtensionMap[fbDocuemnt.doctype]}"
            )
            val fileExists = file.exists()
            doSameAsDownload(position, fbDocuemnt, fileExists)
        }
        else{
           openIntent(subjectName,document.name+"${fileExtensionMap[document.type]}",document.type)
        }
    }

    override fun onDeleteClicked(position: Int, imageView: ImageView) {
        TODO("Not yet implemented")
    }

    override fun onCancelClicked(position: Int) {
        TODO("Not yet implemented")
    }

    override fun onDownloadClicked(
        position: Int,
        fbDocument: FirebaseDocumentFile,
        fileExists: Boolean
    ) {
        doSameAsDownload(position, fbDocument, fileExists)
    }

    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        val result2 = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        return result == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun isActivityForIntentAvailable(
        context: Context,
        intent: Intent?
    ): Boolean {
        val packageManager = context.packageManager
        val list: List<*> =
            packageManager.queryIntentActivities(intent!!, PackageManager.MATCH_DEFAULT_ONLY)
        return list.size > 0
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ),
            123
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            123 -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(
                    this@SubjectdocumentsActivity,
                    "Click again to start download",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                Toast.makeText(
                    this@SubjectdocumentsActivity,
                    "Permissions denied",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
    private fun doSameAsDownload(position: Int,
                                 fbDocument: FirebaseDocumentFile,
                                 fileExists: Boolean){
        if (checkPermission()) {
            if(fileExists){
                // Open file with user selected app
               openIntent(subjectName,fbDocument.docname+"${fileExtensionMap[fbDocument.doctype]}",fbDocument.doctype)
            }
            else {
                if(com.saitejajanjirala.snistforum.utils.Network.isNetworkConnected(this)) {
                    val downloadmanager =
                        getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                    val uri = Uri.parse(fbDocument.docUrl)
                    val request = DownloadManager.Request(uri)
                    val fileName=fbDocument.docname+"${fileExtensionMap[fbDocument.doctype]}"
                    request.setTitle(fbDocument.docname)
                    Toaster.show(applicationContext,"download started")
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    request.setDestinationInExternalPublicDir(
                        "/SNISTFORUM/${fbDocument.subjectname}",
                       fileName
                    )
                    request.setAllowedOverMetered(true)
                    // Set if download is allowed on Mobile network
                    // Set if download is allowed on Mobile network
                    request.setAllowedOverRoaming(true)
                    downloadmanager.enqueue(request)
                }
                else{
                    Toaster.show(this,getString(R.string.no_internet_connection))
                }
            }
        } else {
            requestPermission()
        }
    }
    private fun openIntent(subjectnname:String,documentnname:String,type:String){
        val file =
            File("${Keys.DOWNLOADS_FOLDER_PATH}/$subjectnname/$documentnname")
        var uri = Uri.fromFile(file)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            if (file.exists()) {
                uri = FileProvider.getUriForFile(
                    this,
                    BuildConfig.APPLICATION_ID.toString() + ".provider",
                    file
                )
            }
        }
        grantUriPermission(
            BuildConfig.APPLICATION_ID + ".provider",
            uri, Intent.FLAG_GRANT_READ_URI_PERMISSION
        )
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.setDataAndType(uri,type)
        if (isActivityForIntentAvailable(
                this,
                intent
            )
        ) {
            intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            startActivity(intent)
        }
        else{
            Toaster.show(this,"no app found to open this file")
        }
    }
    override fun onStart() {
        super.onStart()
        if(from!="download") {
            timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    runOnUiThread {
                        documentsAdapter.notifyDataSetChanged()
                    }
                }
            }, 2000, 2000)
        }
    }

    override fun onStop() {
        super.onStop()
        if(from!="download") {
            timer.cancel()
        }
    }

    fun dumpImageMetaData(uri: Uri) {
        val cr = this.contentResolver
        val mime = cr.getType(uri)
        val cursor: Cursor? = cr.query(
            uri, null, null, null, null, null
        )

        cursor?.use {
            if (it.moveToFirst()) {
                val displayName: String =
                    it.getString(it.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                val mimeTypes = arrayOf(
                    "application/vnd.ms-powerpoint",
                    "application/pdf",
                    "application/msword",
                    "application/vnd.openxmlformats-officedocument.presentationml.presentation",
                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
                )
                Log.i("metadata", "Display Name: $displayName Type:$mime")
                val sizeIndex: Int = it.getColumnIndex(OpenableColumns.SIZE)
                val size: String = if (!it.isNull(sizeIndex)) {
                    // Technically the column stores an int, but cursor.getString()
                    // will do the conversion automatically.
                    it.getString(sizeIndex)
                } else {
                    "Unknown"
                }
                Log.i("metadata", "Size: $size")
                if (mime in mimeTypes) {
                    val document =
                        mime?.let { it1 -> Document(displayName.split(".")[0], it1, uri) }
                    if (document != null) {
                        selectedDocuments.add(document)
                    }
                }
            }
        }
    }

}