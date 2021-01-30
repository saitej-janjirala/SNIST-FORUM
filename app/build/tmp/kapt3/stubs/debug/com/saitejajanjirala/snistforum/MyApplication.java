package com.saitejajanjirala.snistforum;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/saitejajanjirala/snistforum/MyApplication;", "Landroid/app/Application;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "sharedPreferences", "Landroid/content/SharedPreferences;", "getCompositeDisposable", "getDatabaseService", "Lcom/saitejajanjirala/snistforum/db/MyDatabaseService;", "getSharedPrefInstance", "onCreate", "", "app_debug"})
public final class MyApplication extends android.app.Application {
    private android.content.SharedPreferences sharedPreferences;
    private io.reactivex.disposables.CompositeDisposable compositeDisposable;
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getSharedPrefInstance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.disposables.CompositeDisposable getCompositeDisposable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.saitejajanjirala.snistforum.db.MyDatabaseService getDatabaseService() {
        return null;
    }
    
    public MyApplication() {
        super();
    }
}