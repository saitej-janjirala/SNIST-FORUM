package com.saitejajanjirala.snistforum.activities.upload

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.saitejajanjirala.snistforum.MyApplication
import com.saitejajanjirala.snistforum.R
import com.saitejajanjirala.snistforum.activities.search.SearchActivity
import com.saitejajanjirala.snistforum.adapter.DocumentAdpater
import com.saitejajanjirala.snistforum.base.ViewModelProviderFactory
import com.saitejajanjirala.snistforum.models.Document
import com.saitejajanjirala.snistforum.models.FirebaseDocumentFile
import com.saitejajanjirala.snistforum.utils.Keys
import com.saitejajanjirala.snistforum.utils.Toaster
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class UploadActivity : AppCompatActivity() ,DocumentAdpater.OnDocumentItemClickListener{
    private lateinit var documentsRecyclerview: RecyclerView
    private lateinit var uploadSubjects: Button
    private lateinit var getDocs: Button
    private lateinit var subjectName: EditText
    private var isValid = false
    private lateinit var selectedDocs: ArrayList<Document>
    private lateinit var firebaseDocumentFiles: ArrayList<FirebaseDocumentFile>
    private lateinit var documentAdapter: DocumentAdpater
    private lateinit var db: FirebaseFirestore
    private lateinit var topLayout: ConstraintLayout
    private lateinit var uploadViewModel: UploadViewModel
    private lateinit var progressLayout: RelativeLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var progresstext: TextView
    private lateinit var okayBtn: Button
    private lateinit var updateBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)
        supportActionBar?.title = "Upload"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setUpViewModel()
        initView()
        setUpListeners()
        selectedDocs = ArrayList()
        firebaseDocumentFiles = ArrayList()
        documentAdapter = DocumentAdpater(
            this@UploadActivity,
            selectedDocs,
            "upload",
            firebaseDocumentFiles,
        this)
        documentsRecyclerview.adapter = documentAdapter
        db = FirebaseFirestore.getInstance()
    }

    private fun initView() {
        subjectName = findViewById(R.id.subject_name)
        uploadSubjects = findViewById(R.id.upload_subjects)
        getDocs = findViewById(R.id.get_docs)
        documentsRecyclerview = findViewById(R.id.documents_recyclerview)
        topLayout = findViewById(R.id.top_layout)
        progressBar = findViewById(R.id.dialog_progress)
        progresstext = findViewById(R.id.dialog_text)
        okayBtn = findViewById(R.id.dialog_okay)
        progressLayout = findViewById(R.id.progress_layout)
        updateBtn=findViewById(R.id.update_subjects)
    }

    private fun setUpListeners() {
        getDocs.setOnClickListener {
            if (checkPermission()) {
                selectedDocs.clear()
                documentAdapter.notifyDataSetChanged()
                val intent = Intent()
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                intent.type = "*/*"
                intent.action = Intent.ACTION_OPEN_DOCUMENT
                intent.addCategory(Intent.CATEGORY_OPENABLE)
                startActivityForResult(intent, Keys.PICK_DOCUMENT_MULTIPLE);
            } else {
                requestPermission()
            }
        }
        updateBtn.setOnClickListener {
            if(progressLayout.visibility!=View.VISIBLE){
                val intent=Intent(this@UploadActivity,SearchActivity::class.java)
                intent.putExtra("from","upload")
                startActivity(intent)
            }
        }
        uploadViewModel.message.observe(this, androidx.lifecycle.Observer {
            Toaster.show(this, it)
        })
        okayBtn.setOnClickListener {
            progressLayout.visibility = View.GONE
            topLayout.alpha = 1f
        }
        uploadSubjects.setOnClickListener {
            val subject = subjectName.text.toString().toLowerCase(Locale.ROOT)
            if (subject == null || subject.isEmpty()) {
                Toaster.show(this, "enter the name of the subject")
            } else if (selectedDocs.size == 0) {
                Toaster.show(this, "You have to upload atleast one document")
            } else {
                if (com.saitejajanjirala.snistforum.utils.Network.isNetworkConnected(this)) {
                    db.document("subjects/$subject")
                        .get()
                        .addOnSuccessListener {
                            val data = it.data
                            if (data?.get("created") == true) {
                                Toaster.show(this, "subject with this name already exists")
                            } else {
                                showProgressLayout()
                                Handler().postDelayed({
                                    val firebaseStorage = FirebaseStorage
                                        .getInstance().reference
                                    var count = 0
                                    val originalcount=selectedDocs.size
                                    for (document in selectedDocs) {
                                        document.uri?.let { it1 ->
                                            val name = document.name
                                            val path = "uploads/$name${System.currentTimeMillis()}"
                                            val ref = firebaseStorage.child(path)
                                            ref.putFile(it1)
                                                .addOnFailureListener {
                                                    count+=1
                                                    uploadViewModel.message.postValue("$name uploading is failed")
                                                    if (count==originalcount) {
                                                        setSubjectInfo(subject)
                                                    }
                                                }
                                                .addOnSuccessListener {
                                                    ref.downloadUrl.addOnSuccessListener { fileurl ->
                                                        val url = fileurl.toString()
                                                        val docref="${System.currentTimeMillis()}"
                                                        val firebaseDocumentFile =
                                                            FirebaseDocumentFile(
                                                                subject,
                                                                name,
                                                                url,
                                                                document.type,
                                                                false,
                                                                docref
                                                            )
                                                        count+=1
                                                        db.document("subjects/$subject/documents/$docref")
                                                            .set(firebaseDocumentFile)
                                                            .addOnSuccessListener {
                                                            }
                                                            .addOnFailureListener { exception ->
                                                                exception.message?.let { it2 ->
                                                                    uploadViewModel.message.postValue(
                                                                        it2
                                                                    )
                                                                }
                                                            }
                                                        if (count==originalcount) {
                                                            setSubjectInfo(subject)
                                                        }

                                                    }
                                                }
                                        }
                                    }
                                }, 500)
                            }
                        }
                        .addOnFailureListener {
                            uploadViewModel.message.postValue(it.message!!)
                        }
                } else {
                    Toaster.show(this, getString(R.string.no_internet_connection))
                }
            }
        }
    }

    override fun onBackPressed() {
        if (progressLayout.visibility != View.VISIBLE) {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (progressLayout.visibility != View.VISIBLE) {
            finish()
        }
        return super.onSupportNavigateUp()
    }

    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(
            this@UploadActivity, Manifest.permission.READ_EXTERNAL_STORAGE
        )
        return result == PackageManager.PERMISSION_GRANTED

    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this@UploadActivity,
            arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ),
            Keys.PERMISSION_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            Keys.PERMISSION_REQUEST_CODE -> if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                Toaster.show(this, "click again to select documents")

            } else {
                Toaster.show(this, "permission denied")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Keys.PICK_DOCUMENT_MULTIPLE && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                Log.i("data", "null")
            } else {
                Log.i("data", "not null")
                if (data.clipData != null) {
                    Log.i("clip data", "not null")
                    val count = data.clipData!!.itemCount
                    for (i in 0 until count) {
                        val uri = data.clipData?.getItemAt(i)?.uri
                        uri?.let { item ->
                            dumpImageMetaData(uri)
                        }
                    }
                } else {
                    Log.i("clip data", "null")
                    val uri = data.data
                    Log.i("path", "${uri?.path}")
                    if (uri != null) {
                        dumpImageMetaData(uri)
                    }
                }
            }
        }
        documentAdapter.notifyDataSetChanged()
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
                        selectedDocs.add(document)
                    }
                }
            }
        }
    }

    private fun setUpViewModel() {
        val app = application as MyApplication
        uploadViewModel = ViewModelProviders.of(
            this,
            ViewModelProviderFactory(
                app.getSharedPrefInstance(),
                app.getCompositeDisposable(),
                app.getDatabaseService())
        ).get(UploadViewModel::class.java)
    }

    private fun showProgressLayout() {
        runOnUiThread {
            progressLayout.visibility = View.VISIBLE
            topLayout.alpha = 0.2f
            progressBar.progress = 0
        }
    }
    private fun setSubjectInfo(subject:String){
        val map = HashMap<String, Any>()
        map["created"] = true
        map["name"]=subject
        db.document("subjects/$subject")
            .set(map)
            .addOnSuccessListener {
                runOnUiThread {
                    progresstext.text =
                        "subject uploaded"
                    progressBar.visibility = View.GONE
                    okayBtn.visibility = View.VISIBLE
                    uploadViewModel.message.postValue("subject uploaded successfully")
                    selectedDocs.clear()
                    documentAdapter.notifyDataSetChanged()
                }
            }
            .addOnFailureListener { exception ->
                exception.message?.let { it2 ->
                    runOnUiThread {
                        progresstext.text =
                            "subject uploaded failed"
                        progressBar.visibility = View.GONE
                        okayBtn.visibility =
                            View.VISIBLE
                        uploadViewModel.message.postValue(
                            it2
                        )
                    }
                }
            }
    }

    override fun onItemClicked(
        position: Int,
        document: Document,
        fbDocuemnt: FirebaseDocumentFile
    ) {
        TODO("Not yet implemented")
    }

    override fun onDeleteClicked(position: Int,imageView: ImageView) {
        TODO("Not yet implemented")
    }

    override fun onCancelClicked(position: Int) {
        selectedDocs.removeAt(position)
        documentAdapter.notifyDataSetChanged()
    }

    override fun onDownloadClicked(
        position: Int,
        fbDocument: FirebaseDocumentFile,
        fileExists: Boolean
    ) {
        TODO("Not yet implemented")
    }
}