package com.saitejajanjirala.snistforum.activities.upload;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010#\u001a\u00020\u0011H\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'J\b\u0010(\u001a\u00020%H\u0002J\"\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020%H\u0016J\u0010\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020+H\u0016J\u0012\u00102\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u000104H\u0014J\u0018\u00105\u001a\u00020%2\u0006\u00101\u001a\u00020+2\u0006\u00106\u001a\u000207H\u0016J \u00108\u001a\u00020%2\u0006\u00101\u001a\u00020+2\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u0011H\u0016J \u0010;\u001a\u00020%2\u0006\u00101\u001a\u00020+2\u0006\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\fH\u0016J-\u0010>\u001a\u00020%2\u0006\u0010*\u001a\u00020+2\u000e\u0010?\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0@2\u0006\u0010B\u001a\u00020CH\u0016\u00a2\u0006\u0002\u0010DJ\b\u0010E\u001a\u00020\u0011H\u0016J\b\u0010F\u001a\u00020%H\u0002J\u0010\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020AH\u0002J\b\u0010I\u001a\u00020%H\u0002J\b\u0010J\u001a\u00020%H\u0002J\b\u0010K\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u000bj\b\u0012\u0004\u0012\u00020\u001a`\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006L"}, d2 = {"Lcom/saitejajanjirala/snistforum/activities/upload/UploadActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/saitejajanjirala/snistforum/adapter/DocumentAdpater$OnDocumentItemClickListener;", "()V", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "documentAdapter", "Lcom/saitejajanjirala/snistforum/adapter/DocumentAdpater;", "documentsRecyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "firebaseDocumentFiles", "Ljava/util/ArrayList;", "Lcom/saitejajanjirala/snistforum/models/FirebaseDocumentFile;", "Lkotlin/collections/ArrayList;", "getDocs", "Landroid/widget/Button;", "isValid", "", "okayBtn", "progressBar", "Landroid/widget/ProgressBar;", "progressLayout", "Landroid/widget/RelativeLayout;", "progresstext", "Landroid/widget/TextView;", "selectedDocs", "Lcom/saitejajanjirala/snistforum/models/Document;", "subjectName", "Landroid/widget/EditText;", "topLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "updateBtn", "uploadSubjects", "uploadViewModel", "Lcom/saitejajanjirala/snistforum/activities/upload/UploadViewModel;", "checkPermission", "dumpImageMetaData", "", "uri", "Landroid/net/Uri;", "initView", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCancelClicked", "position", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteClicked", "imageView", "Landroid/widget/ImageView;", "onDownloadClicked", "fbDocument", "fileExists", "onItemClicked", "document", "fbDocuemnt", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSupportNavigateUp", "requestPermission", "setSubjectInfo", "subject", "setUpListeners", "setUpViewModel", "showProgressLayout", "app_debug"})
public final class UploadActivity extends androidx.appcompat.app.AppCompatActivity implements com.saitejajanjirala.snistforum.adapter.DocumentAdpater.OnDocumentItemClickListener {
    private androidx.recyclerview.widget.RecyclerView documentsRecyclerview;
    private android.widget.Button uploadSubjects;
    private android.widget.Button getDocs;
    private android.widget.EditText subjectName;
    private boolean isValid = false;
    private java.util.ArrayList<com.saitejajanjirala.snistforum.models.Document> selectedDocs;
    private java.util.ArrayList<com.saitejajanjirala.snistforum.models.FirebaseDocumentFile> firebaseDocumentFiles;
    private com.saitejajanjirala.snistforum.adapter.DocumentAdpater documentAdapter;
    private com.google.firebase.firestore.FirebaseFirestore db;
    private androidx.constraintlayout.widget.ConstraintLayout topLayout;
    private com.saitejajanjirala.snistforum.activities.upload.UploadViewModel uploadViewModel;
    private android.widget.RelativeLayout progressLayout;
    private android.widget.ProgressBar progressBar;
    private android.widget.TextView progresstext;
    private android.widget.Button okayBtn;
    private android.widget.Button updateBtn;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    private final void setUpListeners() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    private final boolean checkPermission() {
        return false;
    }
    
    private final void requestPermission() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void dumpImageMetaData(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
    }
    
    private final void setUpViewModel() {
    }
    
    private final void showProgressLayout() {
    }
    
    private final void setSubjectInfo(java.lang.String subject) {
    }
    
    @java.lang.Override()
    public void onItemClicked(int position, @org.jetbrains.annotations.NotNull()
    com.saitejajanjirala.snistforum.models.Document document, @org.jetbrains.annotations.NotNull()
    com.saitejajanjirala.snistforum.models.FirebaseDocumentFile fbDocuemnt) {
    }
    
    @java.lang.Override()
    public void onDeleteClicked(int position, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView) {
    }
    
    @java.lang.Override()
    public void onCancelClicked(int position) {
    }
    
    @java.lang.Override()
    public void onDownloadClicked(int position, @org.jetbrains.annotations.NotNull()
    com.saitejajanjirala.snistforum.models.FirebaseDocumentFile fbDocument, boolean fileExists) {
    }
    
    public UploadActivity() {
        super();
    }
}