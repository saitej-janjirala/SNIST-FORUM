package com.saitejajanjirala.snistforum.activities.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\b\u0010\u001a\u001a\u00020\u0018H\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/saitejajanjirala/snistforum/activities/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "sharedPreferences", "Landroid/content/SharedPreferences;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "(Landroid/content/SharedPreferences;Lio/reactivex/disposables/CompositeDisposable;)V", "clearStatus", "Landroidx/lifecycle/MutableLiveData;", "", "getClearStatus", "()Landroidx/lifecycle/MutableLiveData;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "error", "", "getError", "sharePrefRepo", "Lcom/saitejajanjirala/snistforum/repo/SharePrefRepo;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "status", "getStatus", "clearAdminStatus", "", "fetchAdminStatus", "onCleared", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private com.saitejajanjirala.snistforum.repo.SharePrefRepo sharePrefRepo;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> status = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> clearStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> error = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences sharedPreferences = null;
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.disposables.CompositeDisposable compositeDisposable = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getClearStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getError() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public final void fetchAdminStatus() {
    }
    
    public final void clearAdminStatus() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.disposables.CompositeDisposable getCompositeDisposable() {
        return null;
    }
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences sharedPreferences, @org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.CompositeDisposable compositeDisposable) {
        super();
    }
}