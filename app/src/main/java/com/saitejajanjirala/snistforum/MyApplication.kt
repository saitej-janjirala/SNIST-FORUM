package com.saitejajanjirala.snistforum

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.saitejajanjirala.snistforum.db.MyDatabaseService
import com.saitejajanjirala.snistforum.utils.Keys
import io.reactivex.disposables.CompositeDisposable

class MyApplication : Application() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var compositeDisposable: CompositeDisposable
    override fun onCreate() {
        super.onCreate()
        sharedPreferences = getSharedPreferences(Keys.ADMIN_FILE, Context.MODE_PRIVATE)
        compositeDisposable = CompositeDisposable()
    }

    fun getSharedPrefInstance() = sharedPreferences
    fun getCompositeDisposable() = compositeDisposable

    fun getDatabaseService(): MyDatabaseService {
        return Room.databaseBuilder(
            this.applicationContext,
            MyDatabaseService::class.java,
            "snistforum-miniproject-db"
        )
            .build()
    }
}