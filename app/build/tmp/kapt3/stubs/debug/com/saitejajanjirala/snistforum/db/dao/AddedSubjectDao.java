package com.saitejajanjirala.snistforum.db.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0003H\'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\f\u001a\u00020\u0006H\'\u00a8\u0006\r"}, d2 = {"Lcom/saitejajanjirala/snistforum/db/dao/AddedSubjectDao;", "", "deleteSubject", "Lio/reactivex/Single;", "", "addedSubject", "Lcom/saitejajanjirala/snistforum/db/entities/AddedSubject;", "getAllSubjects", "", "getSize", "insert", "", "subject", "app_debug"})
public abstract interface AddedSubjectDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract io.reactivex.Single<java.lang.Long> insert(@org.jetbrains.annotations.NotNull()
    com.saitejajanjirala.snistforum.db.entities.AddedSubject subject);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select count(*) from addedsubjects")
    public abstract io.reactivex.Single<java.lang.Integer> getSize();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from addedsubjects")
    public abstract io.reactivex.Single<java.util.List<com.saitejajanjirala.snistforum.db.entities.AddedSubject>> getAllSubjects();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Delete()
    public abstract io.reactivex.Single<java.lang.Integer> deleteSubject(@org.jetbrains.annotations.NotNull()
    com.saitejajanjirala.snistforum.db.entities.AddedSubject addedSubject);
}