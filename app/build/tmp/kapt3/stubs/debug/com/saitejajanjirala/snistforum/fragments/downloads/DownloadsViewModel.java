package com.saitejajanjirala.snistforum.fragments.downloads;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/saitejajanjirala/snistforum/fragments/downloads/DownloadsViewModel;", "Landroidx/lifecycle/ViewModel;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "myDatabaseService", "Lcom/saitejajanjirala/snistforum/db/MyDatabaseService;", "(Lio/reactivex/disposables/CompositeDisposable;Lcom/saitejajanjirala/snistforum/db/MyDatabaseService;)V", "isLoading", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "message", "", "getMessage", "subjectsList", "Ljava/util/ArrayList;", "Lcom/saitejajanjirala/snistforum/db/entities/AddedSubject;", "getSubjectsList", "getDownloadedSubjects", "", "onCleared", "app_debug"})
public final class DownloadsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> message = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.saitejajanjirala.snistforum.db.entities.AddedSubject>> subjectsList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLoading = null;
    private final io.reactivex.disposables.CompositeDisposable compositeDisposable = null;
    private final com.saitejajanjirala.snistforum.db.MyDatabaseService myDatabaseService = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.saitejajanjirala.snistforum.db.entities.AddedSubject>> getSubjectsList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public final void getDownloadedSubjects() {
    }
    
    public DownloadsViewModel(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.CompositeDisposable compositeDisposable, @org.jetbrains.annotations.NotNull()
    com.saitejajanjirala.snistforum.db.MyDatabaseService myDatabaseService) {
        super();
    }
}