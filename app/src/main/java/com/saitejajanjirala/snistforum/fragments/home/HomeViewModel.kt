package com.saitejajanjirala.snistforum.fragments.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saitejajanjirala.snistforum.db.MyDatabaseService
import com.saitejajanjirala.snistforum.db.entities.AddedSubject
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    private val compositeDisposable: CompositeDisposable,
private val myDatabaseService: MyDatabaseService) :ViewModel(){
    val message=MutableLiveData<String>()
    val addedSubjectsList=MutableLiveData<List<AddedSubject>>()
    val deleted=MutableLiveData<AddedSubject>()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
    fun getAddedSubjects(){
        compositeDisposable.add(
            myDatabaseService.addedSubjectDao()
                .getAllSubjects()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    addedSubjectsList.postValue(it)
                },{
                    message.postValue(it.message)
                })
        )
    }
    fun deleteSubject(addedSubject: AddedSubject){
        compositeDisposable.add(
            myDatabaseService.addedSubjectDao()
                .deleteSubject(addedSubject)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    if(it!=null) {
                        deleted.postValue(addedSubject)
                    }
                },{
                    message.postValue(it.message)
                })
        )

    }

}