package com.saitejajanjirala.snistforum.models

data class FirebaseDocumentFile(
    val subjectname:String="",
    val docname:String="",
    val docUrl:String="",
    val doctype:String="",
    var isDeleted:Boolean=false,
    val docRefname:String=""
) {
}