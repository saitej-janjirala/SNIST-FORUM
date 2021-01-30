package com.saitejajanjirala.snistforum.activities.update;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u001d\u001a\u00020\u001e2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0002J\b\u0010 \u001a\u00020!H\u0002J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\"\u0010\'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020\u001eH\u0016J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020)H\u0016J\u0012\u00100\u001a\u00020\u001e2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\u0018\u00103\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020)2\u0006\u00104\u001a\u000205H\u0016J \u00106\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020)2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020!H\u0016J \u00109\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020)2\u0006\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\nH\u0016J-\u0010<\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u000e\u0010=\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170>2\u0006\u0010?\u001a\u00020@H\u0016\u00a2\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020!H\u0016J\b\u0010C\u001a\u00020\u001eH\u0002J\u0016\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u000205J\b\u0010G\u001a\u00020\u001eH\u0002J\b\u0010H\u001a\u00020\u001eH\u0002J\b\u0010I\u001a\u00020\u001eH\u0002J\b\u0010J\u001a\u00020\u001eH\u0002J\u0006\u0010K\u001a\u00020\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006L"}, d2 = {"Lcom/saitejajanjirala/snistforum/activities/update/UpdateActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/saitejajanjirala/snistforum/adapter/DocumentAdpater$OnDocumentItemClickListener;", "()V", "docsRecyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "documentAdapter", "Lcom/saitejajanjirala/snistforum/adapter/DocumentAdpater;", "fbDocumentList", "Ljava/util/ArrayList;", "Lcom/saitejajanjirala/snistforum/models/FirebaseDocumentFile;", "Lkotlin/collections/ArrayList;", "okayBtn", "Landroid/widget/Button;", "progressBar", "Landroid/widget/ProgressBar;", "progressLayout", "Landroid/widget/RelativeLayout;", "progresstext", "Landroid/widget/TextView;", "selectedDocs", "Lcom/saitejajanjirala/snistforum/models/Document;", "subjectName", "", "topLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "updateViewModel", "Lcom/saitejajanjirala/snistforum/activities/update/UpdateViewModel;", "uploadMore", "addtoList", "", "fbdocslist", "checkPermission", "", "dumpImageMetaData", "uri", "Landroid/net/Uri;", "fetchDocuments", "initView", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCancelClicked", "position", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteClicked", "imageView", "Landroid/widget/ImageView;", "onDownloadClicked", "fbDocument", "fileExists", "onItemClicked", "document", "fbDocuemnt", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSupportNavigateUp", "requestPermission", "setDelete", "isDeleted", "imageview", "setSubjectInfo", "setUpListeners", "setUpViewModel", "showProgressLayout", "uploadMoreDocs", "app_debug"})
public final class UpdateActivity extends androidx.appcompat.app.AppCompatActivity implements com.saitejajanjirala.snistforum.adapter.DocumentAdpater.OnDocumentItemClickListener {
    private android.widget.RelativeLayout progressLayout;
    private android.widget.ProgressBar progressBar;
    private android.widget.TextView progresstext;
    private android.widget.Button okayBtn;
    private com.saitejajanjirala.snistforum.adapter.DocumentAdpater documentAdapter;
    private java.util.ArrayList<com.saitejajanjirala.snistforum.models.Document> selectedDocs;
    private java.util.ArrayList<com.saitejajanjirala.snistforum.models.FirebaseDocumentFile> fbDocumentList;
    private com.saitejajanjirala.snistforum.activities.update.UpdateViewModel updateViewModel;
    private androidx.recyclerview.widget.RecyclerView docsRecyclerview;
    private android.widget.Button uploadMore;
    private androidx.constraintlayout.widget.ConstraintLayout topLayout;
    private java.lang.String subjectName = "";
    
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
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    private final void fetchDocuments() {
    }
    
    private final void addtoList(java.util.ArrayList<com.saitejajanjirala.snistforum.models.FirebaseDocumentFile> fbdocslist) {
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
    
    public final void uploadMoreDocs() {
    }
    
    private final void showProgressLayout() {
    }
    
    private final void setSubjectInfo() {
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
    
    public final void setDelete(boolean isDeleted, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageview) {
    }
    
    public UpdateActivity() {
        super();
    }
}