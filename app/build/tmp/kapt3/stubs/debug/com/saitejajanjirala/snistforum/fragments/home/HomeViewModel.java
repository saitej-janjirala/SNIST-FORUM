package com.saitejajanjirala.snistforum.fragments.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\u0013J\b\u0010\u0016\u001a\u00020\u0013H\u0014R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/saitejajanjirala/snistforum/fragments/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "myDatabaseService", "Lcom/saitejajanjirala/snistforum/db/MyDatabaseService;", "(Lio/reactivex/disposables/CompositeDisposable;Lcom/saitejajanjirala/snistforum/db/MyDatabaseService;)V", "addedSubjectsList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/saitejajanjirala/snistforum/db/entities/AddedSubject;", "getAddedSubjectsList", "()Landroidx/lifecycle/MutableLiveData;", "deleted", "getDeleted", "message", "", "getMessage", "deleteSubject", "", "addedSubject", "getAddedSubjects", "onCleared", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> message = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.saitejajanjirala.snistforum.db.entities.AddedSubject>> addedSubjectsList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.saitejajanjirala.snistforum.db.entities.AddedSubject> deleted = null;
    private final io.reactivex.disposables.CompositeDisposable compositeDisposable = null;
    private final com.saitejajanjirala.snistforum.db.MyDatabaseService myDatabaseService = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.saitejajanjirala.snistforum.db.entities.AddedSubject>> getAddedSubjectsList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.saitejajanjirala.snistforum.db.entities.AddedSubject> getDeleted() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public final void getAddedSubjects() {
    }
    
    public final void deleteSubject(@org.jetbrains.annotations.NotNull()
    com.saitejajanjirala.snistforum.db.entities.AddedSubject addedSubject) {
    }
    
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.CompositeDisposable compositeDisposable, @org.jetbrains.annotations.NotNull()
    com.saitejajanjirala.snistforum.db.MyDatabaseService myDatabaseService) {
        super();
    }
}