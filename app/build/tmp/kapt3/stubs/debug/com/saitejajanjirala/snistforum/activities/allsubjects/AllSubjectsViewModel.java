package com.saitejajanjirala.snistforum.activities.allsubjects;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/saitejajanjirala/snistforum/activities/allsubjects/AllSubjectsViewModel;", "Landroidx/lifecycle/ViewModel;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "myDatabaseService", "Lcom/saitejajanjirala/snistforum/db/MyDatabaseService;", "(Lio/reactivex/disposables/CompositeDisposable;Lcom/saitejajanjirala/snistforum/db/MyDatabaseService;)V", "insertResult", "Landroidx/lifecycle/MutableLiveData;", "", "getInsertResult", "()Landroidx/lifecycle/MutableLiveData;", "isLoading", "", "message", "", "getMessage", "insertSubject", "", "addedSubject", "Lcom/saitejajanjirala/snistforum/db/entities/AddedSubject;", "onCleared", "app_debug"})
public final class AllSubjectsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> message = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> insertResult = null;
    private final io.reactivex.disposables.CompositeDisposable compositeDisposable = null;
    private final com.saitejajanjirala.snistforum.db.MyDatabaseService myDatabaseService = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Long> getInsertResult() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public final void insertSubject(@org.jetbrains.annotations.NotNull()
    com.saitejajanjirala.snistforum.db.entities.AddedSubject addedSubject) {
    }
    
    public AllSubjectsViewModel(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.CompositeDisposable compositeDisposable, @org.jetbrains.annotations.NotNull()
    com.saitejajanjirala.snistforum.db.MyDatabaseService myDatabaseService) {
        super();
    }
}