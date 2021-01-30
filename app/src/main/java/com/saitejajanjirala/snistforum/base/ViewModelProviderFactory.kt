package com.saitejajanjirala.snistforum.base

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.saitejajanjirala.snistforum.activities.admin.AdminViewModel
import com.saitejajanjirala.snistforum.activities.allsubjects.AllSubjectsViewModel
import com.saitejajanjirala.snistforum.activities.main.MainViewModel
import com.saitejajanjirala.snistforum.activities.search.SearchViewModel
import com.saitejajanjirala.snistforum.activities.subjectdocuments.SubjectDocumentViewModel
import com.saitejajanjirala.snistforum.activities.update.UpdateViewModel
import com.saitejajanjirala.snistforum.activities.upload.UploadViewModel
import com.saitejajanjirala.snistforum.db.MyDatabaseService
import com.saitejajanjirala.snistforum.fragments.downloads.DownloadsViewModel
import com.saitejajanjirala.snistforum.fragments.home.HomeViewModel
import io.reactivex.disposables.CompositeDisposable

class ViewModelProviderFactory(
    val sharedPreferences: SharedPreferences,
    val compositeDisposable: CompositeDisposable,
    val myDatabaseService: MyDatabaseService)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(sharedPreferences,compositeDisposable) as T
        }
        else if (modelClass.isAssignableFrom(AdminViewModel::class.java)) {
            return AdminViewModel(sharedPreferences,compositeDisposable) as T
        }
        else if (modelClass.isAssignableFrom(UploadViewModel::class.java)) {
            return UploadViewModel(sharedPreferences) as T
        }
        else if (modelClass.isAssignableFrom(UpdateViewModel::class.java)) {
            return UpdateViewModel(sharedPreferences,compositeDisposable) as T
        }
        else if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(compositeDisposable,myDatabaseService) as T
        }
        else if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(compositeDisposable,myDatabaseService) as T
        }
        else if (modelClass.isAssignableFrom(AllSubjectsViewModel::class.java)) {
            return AllSubjectsViewModel(compositeDisposable,myDatabaseService) as T
        }
        else if (modelClass.isAssignableFrom(SubjectDocumentViewModel::class.java)) {
            return SubjectDocumentViewModel(compositeDisposable,myDatabaseService) as T
        }
        else if (modelClass.isAssignableFrom(DownloadsViewModel::class.java)) {
            return DownloadsViewModel(compositeDisposable,myDatabaseService) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}