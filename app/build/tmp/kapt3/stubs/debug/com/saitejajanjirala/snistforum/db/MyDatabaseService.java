package com.saitejajanjirala.snistforum.db;

import java.lang.System;

@androidx.room.Database(entities = {com.saitejajanjirala.snistforum.db.entities.AddedSubject.class}, exportSchema = false, version = 1)
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/saitejajanjirala/snistforum/db/MyDatabaseService;", "Landroidx/room/RoomDatabase;", "()V", "addedSubjectDao", "Lcom/saitejajanjirala/snistforum/db/dao/AddedSubjectDao;", "app_debug"})
public abstract class MyDatabaseService extends androidx.room.RoomDatabase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.saitejajanjirala.snistforum.db.dao.AddedSubjectDao addedSubjectDao();
    
    public MyDatabaseService() {
        super();
    }
}