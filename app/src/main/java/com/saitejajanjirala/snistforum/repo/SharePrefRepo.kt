package com.saitejajanjirala.snistforum.repo

import android.content.SharedPreferences
import com.saitejajanjirala.snistforum.utils.Keys
import io.reactivex.Single

class SharePrefRepo(val sharedPreferences: SharedPreferences) {
     fun getAdminStatus():Single<Boolean>{
        return Single.just(sharedPreferences.getBoolean(Keys.ADMIN_LOGIN_SUCCESS,false))
    }
     fun setAdminStatus(status:Boolean): Single<Boolean>? {
       return Single.just(sharedPreferences.edit().putBoolean(Keys.ADMIN_LOGIN_SUCCESS,status).commit())
    }
    suspend fun clearAdminStatus(): Single<Boolean>? {
        return Single.just(sharedPreferences.edit().clear().commit())
    }
}