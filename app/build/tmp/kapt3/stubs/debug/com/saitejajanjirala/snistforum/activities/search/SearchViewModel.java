package com.saitejajanjirala.snistforum.activities.search;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/saitejajanjirala/snistforum/activities/search/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "myDatabaseService", "Lcom/saitejajanjirala/snistforum/db/MyDatabaseService;", "(Lio/reactivex/disposables/CompositeDisposable;Lcom/saitejajanjirala/snistforum/db/MyDatabaseService;)V", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "insertResult", "Landroidx/lifecycle/MutableLiveData;", "", "getInsertResult", "()Landroidx/lifecycle/MutableLiveData;", "message", "", "getMessage", "getMyDatabaseService", "()Lcom/saitejajanjirala/snistforum/db/MyDatabaseService;", "insertSubject", "", "addedSubject", "Lcom/saitejajanjirala/snistforum/db/entities/AddedSubject;", "onCleared", "app_debug"})
public final class SearchViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> insertResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> message = null;
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.disposables.CompositeDisposable compositeDisposable = null;
    @org.jetbrains.annotations.NotNull()
    private final com.saitejajanjirala.snistforum.db.MyDatabaseService myDatabaseService = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Long> getInsertResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getMessage() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public final void insertSubject(@org.jetbrains.annotations.NotNull()
    com.saitejajanjirala.snistforum.db.entities.AddedSubject addedSubject) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.disposables.CompositeDisposable getCompositeDisposable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.saitejajanjirala.snistforum.db.MyDatabaseService getMyDatabaseService() {
        return null;
    }
    
    public SearchViewModel(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.CompositeDisposable compositeDisposable, @org.jetbrains.annotations.NotNull()
    com.saitejajanjirala.snistforum.db.MyDatabaseService myDatabaseService) {
        super();
    }
}