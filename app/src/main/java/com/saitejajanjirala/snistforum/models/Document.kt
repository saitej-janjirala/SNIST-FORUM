package com.saitejajanjirala.snistforum.models

import android.net.Uri

data class Document(
    var name:String="",
    var type:String="",
    var uri: Uri?=null
) {
}