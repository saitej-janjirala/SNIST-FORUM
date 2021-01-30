package com.saitejajanjirala.snistforum.activities.allsubjects

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saitejajanjirala.snistforum.db.MyDatabaseService
import com.saitejajanjirala.snistforum.db.entities.AddedSubject
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AllSubjectsViewModel(
    private val compositeDisposable: CompositeDisposable,
    private val myDatabaseService: MyDatabaseService):ViewModel(){
    val isLoading=MutableLiveData<Boolean>()
    val message=MutableLiveData<String>()
    val insertResult=MutableLiveData<Long?>()
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