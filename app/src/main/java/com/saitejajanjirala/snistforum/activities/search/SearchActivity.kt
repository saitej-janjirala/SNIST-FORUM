package com.saitejajanjirala.snistforum.activities.search

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.saitejajanjirala.snistforum.MyApplication
import com.saitejajanjirala.snistforum.R
import com.saitejajanjirala.snistforum.activities.main.MainViewModel
import com.saitejajanjirala.snistforum.activities.subjectdocuments.SubjectdocumentsActivity
import com.saitejajanjirala.snistforum.activities.update.UpdateActivity
import com.saitejajanjirala.snistforum.activities.upload.UploadViewModel
import com.saitejajanjirala.snistforum.base.ViewModelProviderFactory
import com.saitejajanjirala.snistforum.db.entities.AddedSubject
import com.saitejajanjirala.snistforum.utils.Network
import com.saitejajanjirala.snistforum.utils.Toaster
import java.util.*

class SearchActivity : AppCompatActivity() {
    private lateinit var searchView: SearchView
    private lateinit var subjectLayout: ConstraintLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var db: FirebaseFirestore
    private lateinit var subjectName:TextView
    private lateinit var addSubject:ImageView
    private lateinit var searchViewModel: SearchViewModel
    private var fromActivity=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        db = FirebaseFirestore.getInstance()
        initView()
        setUpViewModel()
        setUpListeners()
        intent.getStringExtra("from")?.let {
            fromActivity=it
            if(it=="main"){
                addSubject.visibility=View.VISIBLE
            }
            {
                addSubject.visibility= View.INVISIBLE
            }
        }

    }

    private fun initView() {
        searchView = findViewById(R.id.search_view)
        subjectLayout = findViewById(R.id.subject_layout)
        progressBar = findViewById(R.id.progress_bar)
        subjectName=findViewById(R.id.subject_name)
        addSubject=findViewById(R.id.add_icon)
    }

    private fun setUpListeners() {
        searchViewModel.message.observe(this, androidx.lifecycle.Observer {
            Toaster.show(this@SearchActivity,it)
        })
        searchViewModel.insertResult.observe(this, androidx.lifecycle.Observer {
            if(it!=null){
                Toaster.show(this,"subject added sucessfully")
            }
        })
        addSubject.setOnClickListener {
            val addedSubject=AddedSubject(subjectName = subjectName.text.toString())
            searchViewModel.insertSubject(addedSubject)
        }
        subjectLayout.setOnClickListener {
            if(fromActivity=="upload") {
                if (Network.isNetworkConnected(this)) {
                    val intent = Intent(this@SearchActivity, UpdateActivity::class.java)
                    intent.putExtra("subject", subjectName.text.toString())
                    startActivity(intent)
                } else {
                    Toaster.show(this, getString(R.string.no_internet_connection))
                }
            }
            else{
                val intent=Intent(this@SearchActivity,SubjectdocumentsActivity::class.java)
                intent.putExtra("subject",subjectName.text.toString())
                intent.putExtra("from","view")
                startActivity(intent)
            }
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    if (Network.isNetworkConnected(this@SearchActivity)) {
                        progressBar.visibility = View.VISIBLE
                        db.collection("subjects")
                            .whereEqualTo("name", it.toLowerCase(Locale.ROOT))
                            .get()
                            .addOnSuccessListener { qs ->
                                progressBar.visibility=View.GONE
                                if (qs.documents.size != 0) {
                                    for (i in qs.documents) {
                                        subjectName.text= i.data?.get("name") as CharSequence?
                                        subjectLayout.visibility=View.VISIBLE
                                    }
                                } else {
                                    subjectLayout.visibility=View.GONE
                                    Toaster.show(this@SearchActivity, "no subjects found")
                                }
                            }
                            .addOnFailureListener { exception ->
                                progressBar.visibility=View.GONE
                                Toaster.show(this@SearchActivity, exception.message.toString())
                            }
                    } else {
                        Toaster.show(
                            this@SearchActivity,
                            getString(R.string.no_internet_connection)
                        )
                    }
                } ?: Toaster.show(this@SearchActivity, "query must not be empty")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }
    private fun setUpViewModel() {
        val app=application as MyApplication
        searchViewModel = ViewModelProviders.of(
            this,
            ViewModelProviderFactory(
                app.getSharedPrefInstance(),
                app.getCompositeDisposable(),
                app.getDatabaseService())
        ).get(SearchViewModel::class.java)
    }

}