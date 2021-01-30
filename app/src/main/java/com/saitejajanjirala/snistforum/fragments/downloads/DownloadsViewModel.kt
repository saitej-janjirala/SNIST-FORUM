package com.saitejajanjirala.snistforum.fragments.downloads

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saitejajanjirala.snistforum.db.MyDatabaseService
import com.saitejajanjirala.snistforum.db.entities.AddedSubject
import com.saitejajanjirala.snistforum.utils.Keys
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.io.File

class DownloadsViewModel(
    private val compositeDisposable: CompositeDisposable,
    private val myDatabaseService: MyDatabaseService
) : ViewModel() {
    val message=MutableLiveData<String>()
    val subjectsList=MutableLiveData<ArrayList<AddedSubject>>()
    val isLoading=MutableLiveData<Boolean>()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
    fun getDownloadedSubjects(){
        isLoading.postValue(true)
        val fileFolder=File(Keys.DOWNLOADS_FOLDER_PATH)
        val list=ArrayList<AddedSubject>()
        fileFolder.listFiles()?.forEach {
            val addedSubject=AddedSubject(subjectName = it.name)
            list.add(addedSubject)
        }
        subjectsList.postValue(list)
        isLoading.postValue(false)
    }
}