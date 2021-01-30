package com.saitejajanjirala.snistforum.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saitejajanjirala.snistforum.db.dao.AddedSubjectDao
import com.saitejajanjirala.snistforum.db.entities.AddedSubject

@Database(
    entities = [AddedSubject::class], exportSchema = false, version = 1
)
abstract class MyDatabaseService : RoomDatabase() {

    abstract fun addedSubjectDao(): AddedSubjectDao

}