package com.saitejajanjirala.snistforum.fragments.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.saitejajanjirala.snistforum.MyApplication
import com.saitejajanjirala.snistforum.R
import com.saitejajanjirala.snistforum.activities.allsubjects.AllsubjectsActivity
import com.saitejajanjirala.snistforum.activities.search.SearchActivity
import com.saitejajanjirala.snistforum.activities.subjectdocuments.SubjectdocumentsActivity
import com.saitejajanjirala.snistforum.adapter.SubjectsAdapter
import com.saitejajanjirala.snistforum.base.ViewModelProviderFactory
import com.saitejajanjirala.snistforum.db.entities.AddedSubject
import com.saitejajanjirala.snistforum.utils.Toaster

class HomeFragment : Fragment(),SubjectsAdapter.onItemClickListener {
    companion object {

        const val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment =
                HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var addedSubjectsRecyclerView: RecyclerView
    private lateinit var addSubjectsButton: Button
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var addedSubjectsList:ArrayList<AddedSubject>
    private lateinit var subjectsAdapter: SubjectsAdapter
    private lateinit var emptyLayout:RelativeLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        addedSubjectsList= ArrayList()
        initView(view)
        setUpViewModel()
        setUpListeners()
        subjectsAdapter= SubjectsAdapter(requireContext(),addedSubjectsList,"home",this)
        addedSubjectsRecyclerView.adapter=subjectsAdapter
        homeViewModel.getAddedSubjects()
        return view;
    }

    private fun initView(view: View) {
        view.run {
            addedSubjectsRecyclerView = findViewById(R.id.added_subjects)
            addSubjectsButton = findViewById(R.id.add_subjects_button)
            emptyLayout=findViewById(R.id.empty_layout)
        }
    }
    private fun setUpListeners(){
        homeViewModel.addedSubjectsList.observe(viewLifecycleOwner, Observer {
            if(it!=null){
                addedSubjectsList.clear()
                Log.i("addedsubjects","$it")
                addedSubjectsList.addAll(it)
                subjectsAdapter.notifyDataSetChanged()
                if(addedSubjectsList.size>0){
                    emptyLayout.visibility=View.GONE
                }
            }
        })
        homeViewModel.deleted.observe(this, Observer {
            if(it!=null){
                addedSubjectsList.remove(it)
                subjectsAdapter.notifyDataSetChanged()
                if(addedSubjectsList.size==0){
                    emptyLayout.visibility=View.VISIBLE
                }
            }
        })
        homeViewModel.message.observe(viewLifecycleOwner, Observer {
            if(it!=null) {
                Toaster.show(requireContext(), it)
            }
        })
        addSubjectsButton.setOnClickListener {
            val intent= Intent(this.activity,AllsubjectsActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        homeViewModel.getAddedSubjects()
    }
    private fun setUpViewModel() {
        val app=requireActivity().application as MyApplication
        homeViewModel = ViewModelProviders.of(
            this,
            ViewModelProviderFactory(
                app.getSharedPrefInstance(),
                app.getCompositeDisposable(),
                app.getDatabaseService())
        ).get(HomeViewModel::class.java)
    }

    override fun onItemClicked(position: Int) {
        val intent=Intent(requireActivity(), SubjectdocumentsActivity::class.java)
        intent.putExtra("subject",addedSubjectsList[position].subjectName)
        intent.putExtra("from","view")
        startActivity(intent)
    }

    override fun onDeleteClicked(position: Int) {
        homeViewModel.deleteSubject(addedSubjectsList[position])
    }

    override fun onAddClicked(position: Int) {

    }


}