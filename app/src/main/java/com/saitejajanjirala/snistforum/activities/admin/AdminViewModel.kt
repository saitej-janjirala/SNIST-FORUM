package com.saitejajanjirala.snistforum.activities.admin

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saitejajanjirala.snistforum.repo.SharePrefRepo
import com.saitejajanjirala.snistforum.utils.Keys
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class AdminViewModel(val sharedPreferences: SharedPreferences,val compositeDisposable: CompositeDisposable):ViewModel() {
    val status=MutableLiveData<Boolean>()
    val errror=MutableLiveData<String>()
    private var sharePrefRepo=SharePrefRepo(sharedPreferences)
    fun setStatus(adminStatus:Boolean){
        sharePrefRepo.setAdminStatus(adminStatus)
            ?.subscribeOn(Schedulers.io())
            ?.subscribe (
                {
                    status.postValue(it)
                },
                {
                    errror.postValue(it.message)
                }
            )?.let {
                compositeDisposable.add(
                    it
                )
            }

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}

