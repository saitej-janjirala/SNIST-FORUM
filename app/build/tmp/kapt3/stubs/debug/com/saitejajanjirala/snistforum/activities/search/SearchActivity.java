package com.saitejajanjirala.snistforum.activities.search;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/saitejajanjirala/snistforum/activities/search/SearchActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "addSubject", "Landroid/widget/ImageView;", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "fromActivity", "", "progressBar", "Landroid/widget/ProgressBar;", "searchView", "Landroidx/appcompat/widget/SearchView;", "searchViewModel", "Lcom/saitejajanjirala/snistforum/activities/search/SearchViewModel;", "subjectLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "subjectName", "Landroid/widget/TextView;", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpListeners", "setUpViewModel", "app_debug"})
public final class SearchActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.appcompat.widget.SearchView searchView;
    private androidx.constraintlayout.widget.ConstraintLayout subjectLayout;
    private android.widget.ProgressBar progressBar;
    private com.google.firebase.firestore.FirebaseFirestore db;
    private android.widget.TextView subjectName;
    private android.widget.ImageView addSubject;
    private com.saitejajanjirala.snistforum.activities.search.SearchViewModel searchViewModel;
    private java.lang.String fromActivity = "";
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    private final void setUpListeners() {
    }
    
    private final void setUpViewModel() {
    }
    
    public SearchActivity() {
        super();
    }
}