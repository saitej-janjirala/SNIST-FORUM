package com.saitejajanjirala.snistforum.activities.main

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saitejajanjirala.snistforum.repo.SharePrefRepo
import com.saitejajanjirala.snistforum.utils.Keys
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class MainViewModel(val sharedPreferences: SharedPreferences,val compositeDisposable: CompositeDisposable):ViewModel() {
    private var sharePrefRepo: SharePrefRepo = SharePrefRepo(sharedPreferences)
    val status=MutableLiveData<Boolean>()
    val clearStatus= MutableLiveData<Boolean>()
    val error=MutableLiveData<String>()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
    fun fetchAdminStatus(){
        compositeDisposable.add(
            sharePrefRepo.getAdminStatus()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        status.postValue(it)
                    },{
                        error.postValue(it.message)
                    }
                )
        )
    }
    fun clearAdminStatus(){
        viewModelScope.launch {
            sharePrefRepo.clearAdminStatus()
                ?.subscribeOn(Schedulers.io())
                ?.subscribe({
                    clearStatus.postValue(it)
                },{
                    error.postValue(it.message)
                })?.let {
                    compositeDisposable.add(
                        it
                    )
                }
        }
    }
}