package com.saitejajanjirala.snistforum.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "addedsubjects")
data class AddedSubject (
    @PrimaryKey
    @ColumnInfo(name = "subjectName")
    var subjectName: String =""
    ){
    constructor() : this( "")
}