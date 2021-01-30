package com.saitejajanjirala.snistforum.activities.allsubjects

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.saitejajanjirala.snistforum.MyApplication
import com.saitejajanjirala.snistforum.R
import com.saitejajanjirala.snistforum.activities.search.SearchActivity
import com.saitejajanjirala.snistforum.activities.subjectdocuments.SubjectdocumentsActivity
import com.saitejajanjirala.snistforum.adapter.SubjectsAdapter
import com.saitejajanjirala.snistforum.base.ViewModelProviderFactory
import com.saitejajanjirala.snistforum.db.entities.AddedSubject
import com.saitejajanjirala.snistforum.utils.Network
import com.saitejajanjirala.snistforum.utils.Toaster

class AllsubjectsActivity : AppCompatActivity() ,SubjectsAdapter.onItemClickListener{
    private lateinit var emptyLayout: RelativeLayout
    private lateinit var allSubjectsRecyclerView: RecyclerView
    private lateinit var allSubjectsViewModel: AllSubjectsViewModel
    private lateinit var subjectsAdapter: SubjectsAdapter
    private lateinit var subjectsList: ArrayList<AddedSubject>
    private lateinit var progressBar: ProgressBar
    private lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var lastDocumentSnapshot: DocumentSnapshot
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allsubjects)
        supportActionBar?.title = "All Subjects"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initView()
        setUpViewModel()
        setUpListeners()
        subjectsList = ArrayList()
        mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        subjectsAdapter = SubjectsAdapter(this, subjectsList, "add",this)
        allSubjectsRecyclerView.adapter = subjectsAdapter
        allSubjectsRecyclerView.layoutManager = mLayoutManager
        fetchSubjects()
    }

    private fun initView() {
        allSubjectsRecyclerView = findViewById(R.id.subjects_recyclerview)
        emptyLayout = findViewById(R.id.empty_layout)
        progressBar = findViewById(R.id.progress_bar)
    }

    private fun setUpListeners() {
        allSubjectsViewModel.isLoading.observe(this, Observer {
            if (it != null) {
                if (it) {
                    progressBar.visibility = View.VISIBLE
                } else {
                    progressBar.visibility = View.GONE
                }
            }
        })
        allSubjectsViewModel.message.observe(this, Observer {
            Toaster.show(this, "$it")
        })
        allSubjectsViewModel.insertResult.observe(this, androidx.lifecycle.Observer {
            if(it!=null){
                Toaster.show(this,"subject added sucessfully")
            }
        })
        allSubjectsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) { //check for scroll down
                    val lastVisibleItemPosition =
                        mLayoutManager.findLastCompletelyVisibleItemPosition()
                    if (lastVisibleItemPosition != RecyclerView.NO_POSITION &&
                        lastVisibleItemPosition == subjectsAdapter.itemCount - 1
                    ) {
                        if (Network.isNetworkConnected(this@AllsubjectsActivity)) {
                            if (progressBar.visibility == View.GONE) {
                                loadMore()
                            }
                        }
                    }
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
    }

    private fun setUpViewModel() {
        val app = application as MyApplication
        allSubjectsViewModel = ViewModelProviders.of(
            this,
            ViewModelProviderFactory(
                app.getSharedPrefInstance(),
                app.getCompositeDisposable(),
                app.getDatabaseService()
            )
        ).get(AllSubjectsViewModel::class.java)
    }

    private fun fetchSubjects() {
        allSubjectsViewModel.isLoading.value = true
        val db = FirebaseFirestore.getInstance()
        db.collection("subjects")
            .orderBy("name")
            .limit(25)
            .get()
            .addOnSuccessListener {
                allSubjectsViewModel.isLoading.postValue(false)
                val list = ArrayList<AddedSubject>()
                setLastDocument(it.documents[it.documents.size - 1])
                for (i in it.documents) {
                    i.data?.get("name")?.let { sname ->
                        if (sname is String) {
                            val obj = AddedSubject(sname)
                            list.add(obj)
                        }
                    }
                }
                addData(
                    list
                )
            }
            .addOnFailureListener {
                allSubjectsViewModel.message.postValue(it.message)
                allSubjectsViewModel.isLoading.postValue(false)
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        super.onBackPressed()
        return super.onSupportNavigateUp()
    }
    private fun addData(subsList: ArrayList<AddedSubject>) {
        subjectsList.addAll(subsList)
        if (subjectsList.size > 0) {
            emptyLayout.visibility = View.GONE
        } else {
            emptyLayout.visibility = View.VISIBLE
        }
        subjectsAdapter.notifyDataSetChanged()
    }

    private fun setLastDocument(documentSnapshot: DocumentSnapshot) {
        lastDocumentSnapshot = documentSnapshot
    }

    private fun loadMore() {
        if (lastDocumentSnapshot != null) {
            allSubjectsViewModel.isLoading.value = true
            val db = FirebaseFirestore.getInstance()
            db.collection("subjects")
                .orderBy("name")
                .startAfter(lastDocumentSnapshot)
                .get()
                .addOnSuccessListener {
                    allSubjectsViewModel.isLoading.postValue(false)
                    val list = ArrayList<AddedSubject>()
                    for (i in it.documents) {
                        i.data?.get("name")?.let { sname ->
                            if (sname is String) {
                                val obj = AddedSubject(sname)
                                list.add(obj)
                            }
                        }
                        if(i==it.documents.last()){
                            setLastDocument(i)
                        }
                    }
                }
                .addOnFailureListener {
                    allSubjectsViewModel.isLoading.postValue(false)
                    allSubjectsViewModel.message.postValue(it.message)
                }
        }
    }

    override fun onItemClicked(position: Int) {
        val intent=Intent(this@AllsubjectsActivity,SubjectdocumentsActivity::class.java)
        intent.putExtra("subject",subjectsList[position].subjectName)
        intent.putExtra("from","view")
        startActivity(intent)
    }

    override fun onDeleteClicked(position: Int) {

    }

    override fun onAddClicked(position: Int) {
        allSubjectsViewModel.insertSubject(subjectsList[position])
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.action_search){
            val intent= Intent(this@AllsubjectsActivity,SearchActivity::class.java)
            intent.putExtra("from","main")
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}