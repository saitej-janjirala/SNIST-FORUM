package com.saitejajanjirala.snistforum.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/saitejajanjirala/snistforum/repo/SharePrefRepo;", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "clearAdminStatus", "Lio/reactivex/Single;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAdminStatus", "setAdminStatus", "status", "app_debug"})
public final class SharePrefRepo {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences sharedPreferences = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.lang.Boolean> getAdminStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final io.reactivex.Single<java.lang.Boolean> setAdminStatus(boolean status) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object clearAdminStatus(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.reactivex.Single<java.lang.Boolean>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    public SharePrefRepo(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences sharedPreferences) {
        super();
    }
}