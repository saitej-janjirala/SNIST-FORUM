package com.saitejajanjirala.snistforum.activities.allsubjects;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\'\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020#H\u0016J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u0017H\u0002J\b\u0010/\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/saitejajanjirala/snistforum/activities/allsubjects/AllsubjectsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/saitejajanjirala/snistforum/adapter/SubjectsAdapter$onItemClickListener;", "()V", "allSubjectsRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "allSubjectsViewModel", "Lcom/saitejajanjirala/snistforum/activities/allsubjects/AllSubjectsViewModel;", "emptyLayout", "Landroid/widget/RelativeLayout;", "lastDocumentSnapshot", "Lcom/google/firebase/firestore/DocumentSnapshot;", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "progressBar", "Landroid/widget/ProgressBar;", "subjectsAdapter", "Lcom/saitejajanjirala/snistforum/adapter/SubjectsAdapter;", "subjectsList", "Ljava/util/ArrayList;", "Lcom/saitejajanjirala/snistforum/db/entities/AddedSubject;", "Lkotlin/collections/ArrayList;", "addData", "", "subsList", "fetchSubjects", "initView", "loadMore", "onAddClicked", "position", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onDeleteClicked", "onItemClicked", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onSupportNavigateUp", "setLastDocument", "documentSnapshot", "setUpListeners", "setUpViewModel", "app_debug"})
public final class AllsubjectsActivity extends androidx.appcompat.app.AppCompatActivity implements com.saitejajanjirala.snistforum.adapter.SubjectsAdapter.onItemClickListener {
    private android.widget.RelativeLayout emptyLayout;
    private androidx.recyclerview.widget.RecyclerView allSubjectsRecyclerView;
    private com.saitejajanjirala.snistforum.activities.allsubjects.AllSubjectsViewModel allSubjectsViewModel;
    private com.saitejajanjirala.snistforum.adapter.SubjectsAdapter subjectsAdapter;
    private java.util.ArrayList<com.saitejajanjirala.snistforum.db.entities.AddedSubject> subjectsList;
    private android.widget.ProgressBar progressBar;
    private androidx.recyclerview.widget.LinearLayoutManager mLayoutManager;
    private com.google.firebase.firestore.DocumentSnapshot lastDocumentSnapshot;
    
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
    
    private final void fetchSubjects() {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    private final void addData(java.util.ArrayList<com.saitejajanjirala.snistforum.db.entities.AddedSubject> subsList) {
    }
    
    private final void setLastDocument(com.google.firebase.firestore.DocumentSnapshot documentSnapshot) {
    }
    
    private final void loadMore() {
    }
    
    @java.lang.Override()
    public void onItemClicked(int position) {
    }
    
    @java.lang.Override()
    public void onDeleteClicked(int position) {
    }
    
    @java.lang.Override()
    public void onAddClicked(int position) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public AllsubjectsActivity() {
        super();
    }
}