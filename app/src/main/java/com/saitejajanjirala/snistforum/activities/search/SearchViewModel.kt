package com.saitejajanjirala.snistforum.activities.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saitejajanjirala.snistforum.db.MyDatabaseService
import com.saitejajanjirala.snistforum.db.entities.AddedSubject
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchViewModel(
    val compositeDisposable: CompositeDisposable,
    val myDatabaseService: MyDatabaseService
) : ViewModel() {
    val insertResult=MutableLiveData<Long?>()
    val message=MutableLiveData<String>()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
    fun insertSubject(addedSubject: AddedSubject){
        compositeDisposable.add(
            myDatabaseService.addedSubjectDao().insert(addedSubject)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    insertResult.postValue(it)
                },{
                    message.postValue(it.message)
                })
        )
    }
}