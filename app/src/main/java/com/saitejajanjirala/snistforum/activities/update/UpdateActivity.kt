package com.saitejajanjirala.snistforum.activities.update

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.saitejajanjirala.snistforum.MyApplication
import com.saitejajanjirala.snistforum.R
import com.saitejajanjirala.snistforum.adapter.DocumentAdpater
import com.saitejajanjirala.snistforum.base.ViewModelProviderFactory
import com.saitejajanjirala.snistforum.models.Document
import com.saitejajanjirala.snistforum.models.FirebaseDocumentFile
import com.saitejajanjirala.snistforum.utils.Keys
import com.saitejajanjirala.snistforum.utils.Network
import com.saitejajanjirala.snistforum.utils.Toaster

class UpdateActivity : AppCompatActivity(), DocumentAdpater.OnDocumentItemClickListener {
    private lateinit var progressLayout: RelativeLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var progresstext: TextView
    private lateinit var okayBtn: Button
    private lateinit var documentAdapter: DocumentAdpater
    private lateinit var selectedDocs: ArrayList<Document>
    private lateinit var fbDocumentList: ArrayList<FirebaseDocumentFile>
    private lateinit var updateViewModel: UpdateViewModel
    private lateinit var docsRecyclerview: RecyclerView
    private lateinit var uploadMore: Button
    private lateinit var topLayout: ConstraintLayout
    private var subjectName: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        supportActionBar?.title = "Update subject"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initView()
        setUpViewModel()
        setUpListeners()
        intent.getStringExtra("subject")?.let {
            subjectName = it
        }
        selectedDocs = ArrayList()
        fbDocumentList = ArrayList()
        documentAdapter = DocumentAdpater(
            this,
            selectedDocs,
            "update",
            fbDocumentList,
            this
        )
        docsRecyclerview.adapter = documentAdapter
        fetchDocuments()
    }

    private fun initView() {
        progressBar = findViewById(R.id.dialog_progress)
        progresstext = findViewById(R.id.dialog_text)
        okayBtn = findViewById(R.id.dialog_okay)
        progressLayout = findViewById(R.id.progress_layout)
        docsRecyclerview = findViewById(R.id.documents_recyclerview)
        uploadMore = findViewById(R.id.upload_more_subjects)
        topLayout = findViewById(R.id.top_layout)
    }

    private fun setUpListeners() {
        updateViewModel.message.observe(this, Observer {
            Toaster.show(this@UpdateActivity, it)
        })
        okayBtn.setOnClickListener {
            progressLayout.visibility = View.GONE
            topLayout.alpha = 1f
            fetchDocuments()
        }
        uploadMore.setOnClickListener {
            if (Network.isNetworkConnected(this@UpdateActivity)) {
                if (checkPermission()) {
                    val intent = Intent()
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                    intent.type = "*/*"
                    intent.action = Intent.ACTION_OPEN_DOCUMENT
                    intent.addCategory(Intent.CATEGORY_OPENABLE)
                    startActivityForResult(intent, Keys.PICK_DOCUMENT_MULTIPLE);
                } else {
                    requestPermission()
                }
            } else {
                Toaster.show(this@UpdateActivity, getString(R.string.no_internet_connection))
            }
        }

    }

    private fun setUpViewModel() {
        val app = application as MyApplication
        updateViewModel = ViewModelProviders.of(
            this,
            ViewModelProviderFactory(
                app.getSharedPrefInstance(),
                app.getCompositeDisposable(),
                app.getDatabaseService()
            )
        ).get(UpdateViewModel::class.java)
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

    private fun fetchDocuments() {
        val db = FirebaseFirestore.getInstance()
        db.collection("subjects/$subjectName/documents")
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
            }
    }

    private fun addtoList(fbdocslist: ArrayList<FirebaseDocumentFile>) {
        fbDocumentList.clear()
        fbDocumentList.addAll(fbdocslist)
        documentAdapter.notifyDataSetChanged()
    }

    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(
            this@UpdateActivity, Manifest.permission.READ_EXTERNAL_STORAGE
        )
        return result == PackageManager.PERMISSION_GRANTED

    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this@UpdateActivity,
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
                uploadMoreDocs()
            }
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
                        selectedDocs.add(document)
                    }
                }
            }
        }
    }

    fun uploadMoreDocs() {
        if (selectedDocs.size > 0) {
            var count = 0
            val originalcount = selectedDocs.size
            showProgressLayout()
            val firebaseStorage = FirebaseStorage.getInstance().reference
            val db = FirebaseFirestore.getInstance()
            for (document in selectedDocs) {
                document.uri?.let { it1 ->
                    val name = document.name
                    val path = "uploads/$name${System.currentTimeMillis()}"
                    val ref = firebaseStorage.child(path)
                    ref.putFile(it1)
                        .addOnFailureListener {
                            count += 1
                            updateViewModel.message.postValue("$name uploading is failed")
                            if (count == originalcount) {
                                setSubjectInfo()
                            }
                        }
                        .addOnSuccessListener {
                            ref.downloadUrl.addOnSuccessListener { fileurl ->
                                val url = fileurl.toString()
                                val docref = "${System.currentTimeMillis()}"
                                val firebaseDocumentFile =
                                    FirebaseDocumentFile(
                                        subjectName,
                                        name,
                                        url,
                                        document.type,
                                        false,
                                        docref
                                    )
                                count += 1
                                db.document("subjects/$subjectName/documents/$docref")
                                    .set(firebaseDocumentFile)
                                    .addOnSuccessListener {
                                    }
                                    .addOnFailureListener { exception ->
                                        exception.message?.let { it2 ->
                                            updateViewModel.message.postValue(
                                                it2
                                            )
                                        }
                                    }
                                if (count == originalcount) {
                                    setSubjectInfo()
                                }

                            }
                        }
                }
            }
        }

    }

    private fun showProgressLayout() {
        runOnUiThread {
            progressLayout.visibility = View.VISIBLE
            topLayout.alpha = 0.2f
            progressBar.progress = 0
        }
    }

    private fun setSubjectInfo() {
        progresstext.text =
            "subject uploaded"
        progressBar.visibility = View.GONE
        okayBtn.visibility = View.VISIBLE
        updateViewModel.message.postValue("subject uploaded successfully")
        selectedDocs.clear()
    }
    //reccyclerview onitemclicks
    override fun onItemClicked(
        position: Int,
        document: Document,
        fbDocuemnt: FirebaseDocumentFile
    ) {
        TODO("Not yet implemented")
    }

    override fun onDeleteClicked(position: Int, imageView: ImageView) {
        val db = FirebaseFirestore.getInstance()
        val mDoc = fbDocumentList[position]
        var isDeleted = mDoc.isDeleted
        if (Network.isNetworkConnected(this@UpdateActivity)) {
            isDeleted = !isDeleted
            val map = HashMap<String, Any>()
            map["deleted"] = isDeleted
            db.document("subjects/${mDoc.subjectname}/documents/${mDoc.docRefname}")
                .update(map)
                .addOnSuccessListener {
                    setDelete(isDeleted, imageView)
                    fbDocumentList[position].isDeleted = isDeleted
                    documentAdapter.notifyDataSetChanged()
                    if (isDeleted) {
                        Toaster.show(this@UpdateActivity, "marked to not show")
                    } else {
                        Toaster.show(this@UpdateActivity, "marked to show")
                    }
                }
                .addOnFailureListener {
                    it.message?.let { it1 -> Toaster.show(this@UpdateActivity, it1) }
                }
        } else {
            Toaster.show(this@UpdateActivity, getString(R.string.no_internet_connection))
        }

    }

    override fun onCancelClicked(position: Int) {

    }

    override fun onDownloadClicked(
        position: Int,
        fbDocument: FirebaseDocumentFile,
        fileExists: Boolean
    ) {
        TODO("Not yet implemented")
    }

    fun setDelete(isDeleted: Boolean, imageview: ImageView) {
        if (isDeleted) {
            imageview.setImageResource(R.drawable.ic_close_eyes)
        } else {
            imageview.setImageResource(R.drawable.ic_open)
        }
    }


}