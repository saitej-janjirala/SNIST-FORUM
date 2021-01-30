package com.saitejajanjirala.snistforum.fragments.downloads

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.saitejajanjirala.snistforum.MyApplication
import com.saitejajanjirala.snistforum.R
import com.saitejajanjirala.snistforum.activities.subjectdocuments.SubjectdocumentsActivity
import com.saitejajanjirala.snistforum.adapter.SubjectsAdapter
import com.saitejajanjirala.snistforum.base.ViewModelProviderFactory
import com.saitejajanjirala.snistforum.db.entities.AddedSubject
import com.saitejajanjirala.snistforum.fragments.home.HomeFragment
import com.saitejajanjirala.snistforum.fragments.home.HomeViewModel
import com.saitejajanjirala.snistforum.utils.Toaster

class DownloadFragment : Fragment(),SubjectsAdapter.onItemClickListener {
    private lateinit var downloadedSubjectsList:ArrayList<AddedSubject>
    private lateinit var downloadedSubjectsRecyclerview:RecyclerView
    private lateinit var emptyLayout:RelativeLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var subjectAdapter:SubjectsAdapter
    private lateinit var downloadsViewModel: DownloadsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_download, container, false)
        initView(view)
        setUpViewModel()
        setUpListeners()
        downloadedSubjectsList= ArrayList()
        subjectAdapter= SubjectsAdapter(requireContext(),downloadedSubjectsList,"download",this)
        downloadedSubjectsRecyclerview.adapter=subjectAdapter
        downloadsViewModel.getDownloadedSubjects()
        return view;
    }
    private fun initView(view: View){
        view.run {
            downloadedSubjectsRecyclerview=findViewById(R.id.downloaded_subjects_recyclerview)
            emptyLayout=findViewById(R.id.empty_layout)
            progressBar=findViewById(R.id.progress_bar)
        }
    }
    private fun setUpListeners(){
        downloadsViewModel.message.observe(viewLifecycleOwner, Observer {
            if(it!=null) {
                Toaster.show(requireContext(), it)
            }
        })
        downloadsViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if(it!=null){
                if(it){
                    progressBar.visibility=View.VISIBLE
                }
                else{
                    progressBar.visibility=View.GONE
                }
            }
        })
        downloadsViewModel.subjectsList.observe(this, Observer {
            if(it!=null){
                downloadedSubjectsList.clear()
                downloadedSubjectsList.addAll(it)
                subjectAdapter.notifyDataSetChanged()
                if(downloadedSubjectsList.size==0){
                    emptyLayout.visibility=View.VISIBLE
                }
                else{
                    emptyLayout.visibility=View.GONE
                }
            }
        })
    }
    companion object {
        const val TAG = "DownloadFragment"
        fun newInstance(): DownloadFragment {
            val args = Bundle()
            val fragment =
                DownloadFragment()
            fragment.arguments = args
            return fragment
        }
    }
    private fun setUpViewModel() {
        val app=requireActivity().application as MyApplication
        downloadsViewModel = ViewModelProviders.of(
            this,
            ViewModelProviderFactory(
                app.getSharedPrefInstance(),
                app.getCompositeDisposable(),
                app.getDatabaseService())
        ).get(DownloadsViewModel::class.java)
    }


    override fun onItemClicked(position: Int) {
        val intent= Intent(requireActivity(), SubjectdocumentsActivity::class.java)
        intent.putExtra("subject",downloadedSubjectsList[position].subjectName)
        intent.putExtra("from","download")
        startActivity(intent)
    }

    override fun onDeleteClicked(position: Int) {
        TODO("Not yet implemented")
    }

    override fun onAddClicked(position: Int) {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        downloadsViewModel.getDownloadedSubjects()
    }
}