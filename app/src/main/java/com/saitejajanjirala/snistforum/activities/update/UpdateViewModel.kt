package com.saitejajanjirala.snistforum.activities.update

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saitejajanjirala.snistforum.models.Document
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import kotlin.collections.ArrayList

class UpdateViewModel(val sharedPreferences: SharedPreferences,
                      val compositeDisposable: CompositeDisposable) : ViewModel() {
    val message = MutableLiveData<String>()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}