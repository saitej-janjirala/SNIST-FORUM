package com.saitejajanjirala.snistforum.activities.upload

import android.content.SharedPreferences
import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.saitejajanjirala.snistforum.models.Document
import com.saitejajanjirala.snistforum.models.FirebaseDocumentFile
import kotlinx.coroutines.launch

class UploadViewModel(val sharedPreferences: SharedPreferences) : ViewModel() {
    val progressText = MutableLiveData<String>()
    val progressStatus = MutableLiveData<Boolean>()
    val message = MutableLiveData<String>()
    val clear = MutableLiveData<Boolean>()
    val showdialog = MutableLiveData<Boolean>()
    lateinit var db: FirebaseFirestore

    fun setProgressText(text: String) {
        progressText.postValue(text)
    }

    fun setProgressStatus(status: Boolean) {
        progressStatus.postValue(status)
    }

}