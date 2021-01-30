package com.saitejajanjirala.snistforum.db.dao

import androidx.room.*
import com.saitejajanjirala.snistforum.db.entities.AddedSubject
import io.reactivex.Single

@Dao
interface AddedSubjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(subject: AddedSubject): Single<Long>

    @Query("select count(*) from addedsubjects")
    fun getSize(): Single<Int>

    @Query("select * from addedsubjects")
    fun getAllSubjects(): Single<List<AddedSubject>>

    @Delete
    fun deleteSubject(addedSubject: AddedSubject):Single<Int>
}