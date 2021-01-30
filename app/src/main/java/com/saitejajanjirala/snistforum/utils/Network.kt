package com.saitejajanjirala.snistforum.utils

import android.content.Context
import android.net.ConnectivityManager

object Network {
    fun isNetworkConnected(context:Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork?.isConnected ?: false
    }

}