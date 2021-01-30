package com.saitejajanjirala.snistforum.activities.update

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class UpdateViewModel(val sharedPreferences: SharedPreferences,
                      val compositeDisposable: CompositeDisposable):ViewModel() {
    val message = MutableLiveData<String>()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}