package com.saitejajanjirala.snistforum.fragments.downloads;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/saitejajanjirala/snistforum/fragments/downloads/DownloadFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/saitejajanjirala/snistforum/adapter/SubjectsAdapter$onItemClickListener;", "()V", "downloadedSubjectsList", "Ljava/util/ArrayList;", "Lcom/saitejajanjirala/snistforum/db/entities/AddedSubject;", "Lkotlin/collections/ArrayList;", "downloadedSubjectsRecyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "downloadsViewModel", "Lcom/saitejajanjirala/snistforum/fragments/downloads/DownloadsViewModel;", "emptyLayout", "Landroid/widget/RelativeLayout;", "progressBar", "Landroid/widget/ProgressBar;", "subjectAdapter", "Lcom/saitejajanjirala/snistforum/adapter/SubjectsAdapter;", "initView", "", "view", "Landroid/view/View;", "onAddClicked", "position", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteClicked", "onItemClicked", "onResume", "setUpListeners", "setUpViewModel", "Companion", "app_debug"})
public final class DownloadFragment extends androidx.fragment.app.Fragment implements com.saitejajanjirala.snistforum.adapter.SubjectsAdapter.onItemClickListener {
    private java.util.ArrayList<com.saitejajanjirala.snistforum.db.entities.AddedSubject> downloadedSubjectsList;
    private androidx.recyclerview.widget.RecyclerView downloadedSubjectsRecyclerview;
    private android.widget.RelativeLayout emptyLayout;
    private android.widget.ProgressBar progressBar;
    private com.saitejajanjirala.snistforum.adapter.SubjectsAdapter subjectAdapter;
    private com.saitejajanjirala.snistforum.fragments.downloads.DownloadsViewModel downloadsViewModel;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "DownloadFragment";
    public static final com.saitejajanjirala.snistforum.fragments.downloads.DownloadFragment.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initView(android.view.View view) {
    }
    
    private final void setUpListeners() {
    }
    
    private final void setUpViewModel() {
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
    public void onResume() {
    }
    
    public DownloadFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/saitejajanjirala/snistforum/fragments/downloads/DownloadFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/saitejajanjirala/snistforum/fragments/downloads/DownloadFragment;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.saitejajanjirala.snistforum.fragments.downloads.DownloadFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}