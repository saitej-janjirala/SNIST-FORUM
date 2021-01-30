package com.saitejajanjirala.snistforum.activities.subjectdocuments

import android.content.ContentResolver
import android.util.Log
import android.webkit.MimeTypeMap
import androidx.core.content.ContentResolverCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saitejajanjirala.snistforum.db.MyDatabaseService
import com.saitejajanjirala.snistforum.models.Document
import com.saitejajanjirala.snistforum.utils.Keys
import io.reactivex.disposables.CompositeDisposable
import java.io.File

class SubjectDocumentViewModel(
    private val compositeDisposable: CompositeDisposable,
    private val myDatabaseService: MyDatabaseService
) : ViewModel() {
    val isLoading= MutableLiveData<Boolean>()
    val message= MutableLiveData<String>()
    val DownloadedFilesList=MutableLiveData<ArrayList<File>>()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
    fun getSubjectDocuments(subjectName:String){
        isLoading.postValue(true)
        val fileFolder= File("${Keys.DOWNLOADS_FOLDER_PATH}/$subjectName")
        fileFolder.listFiles()?.let {
            val list=ArrayList<File>()
            for(i in it){
                list.add(i)
                Log.i("path","extension==>  ${i.extension}")
            }
            DownloadedFilesList.postValue(list)
        }
        isLoading.postValue(false)
    }
}