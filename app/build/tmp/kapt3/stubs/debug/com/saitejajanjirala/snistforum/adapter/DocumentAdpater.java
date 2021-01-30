package com.saitejajanjirala.snistforum.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001f BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0006j\b\u0012\u0004\u0012\u00020\f`\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0016\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0006j\b\u0012\u0004\u0012\u00020\f`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/saitejajanjirala/snistforum/adapter/DocumentAdpater;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/saitejajanjirala/snistforum/adapter/DocumentAdpater$DocumentViewHolder;", "context", "Landroid/content/Context;", "documentList", "Ljava/util/ArrayList;", "Lcom/saitejajanjirala/snistforum/models/Document;", "Lkotlin/collections/ArrayList;", "type", "", "Fbdocuments", "Lcom/saitejajanjirala/snistforum/models/FirebaseDocumentFile;", "onDocumentItemClickListener", "Lcom/saitejajanjirala/snistforum/adapter/DocumentAdpater$OnDocumentItemClickListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;Lcom/saitejajanjirala/snistforum/adapter/DocumentAdpater$OnDocumentItemClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setDelete", "isDeleted", "", "imageview", "Landroid/widget/ImageView;", "DocumentViewHolder", "OnDocumentItemClickListener", "app_debug"})
public final class DocumentAdpater extends androidx.recyclerview.widget.RecyclerView.Adapter<com.saitejajanjirala.snistforum.adapter.DocumentAdpater.DocumentViewHolder> {
    private final android.content.Context context = null;
    private final java.util.ArrayList<com.saitejajanjirala.snistforum.models.Document> documentList = null;
    private final java.lang.String type = null;
    private final java.util.ArrayList<com.saitejajanjirala.snistforum.models.FirebaseDocumentFile> Fbdocuments = null;
    private final com.saitejajanjirala.snistforum.adapter.DocumentAdpater.OnDocumentItemClickListener onDocumentItemClickListener = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.saitejajanjirala.snistforum.adapter.DocumentAdpater.DocumentViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.saitejajanjirala.snistforum.adapter.DocumentAdpater.DocumentViewHolder holder, int position) {
    }
    
    public final void setDelete(boolean isDeleted, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageview) {
    }
    
    public DocumentAdpater(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.saitejajanjirala.snistforum.models.Document> documentList, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.saitejajanjirala.snistforum.models.FirebaseDocumentFile> Fbdocuments, @org.jetbrains.annotations.NotNull()
    com.saitejajanjirala.snistforum.adapter.DocumentAdpater.OnDocumentItemClickListener onDocumentItemClickListener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/saitejajanjirala/snistforum/adapter/DocumentAdpater$DocumentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/saitejajanjirala/snistforum/adapter/DocumentAdpater;Landroid/view/View;)V", "cancelBtn", "Landroid/widget/ImageView;", "getCancelBtn", "()Landroid/widget/ImageView;", "deleteBtn", "getDeleteBtn", "docName", "Landroid/widget/TextView;", "getDocName", "()Landroid/widget/TextView;", "docType", "getDocType", "downloadBtn", "getDownloadBtn", "app_debug"})
    public final class DocumentViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView docType = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView docName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView cancelBtn = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView downloadBtn = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView deleteBtn = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getDocType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getDocName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getCancelBtn() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getDownloadBtn() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getDeleteBtn() {
            return null;
        }
        
        public DocumentViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH&\u00a8\u0006\u0012"}, d2 = {"Lcom/saitejajanjirala/snistforum/adapter/DocumentAdpater$OnDocumentItemClickListener;", "", "onCancelClicked", "", "position", "", "onDeleteClicked", "imageView", "Landroid/widget/ImageView;", "onDownloadClicked", "fbDocument", "Lcom/saitejajanjirala/snistforum/models/FirebaseDocumentFile;", "fileExists", "", "onItemClicked", "document", "Lcom/saitejajanjirala/snistforum/models/Document;", "fbDocuemnt", "app_debug"})
    public static abstract interface OnDocumentItemClickListener {
        
        public abstract void onItemClicked(int position, @org.jetbrains.annotations.NotNull()
        com.saitejajanjirala.snistforum.models.Document document, @org.jetbrains.annotations.NotNull()
        com.saitejajanjirala.snistforum.models.FirebaseDocumentFile fbDocuemnt);
        
        public abstract void onDeleteClicked(int position, @org.jetbrains.annotations.NotNull()
        android.widget.ImageView imageView);
        
        public abstract void onCancelClicked(int position);
        
        public abstract void onDownloadClicked(int position, @org.jetbrains.annotations.NotNull()
        com.saitejajanjirala.snistforum.models.FirebaseDocumentFile fbDocument, boolean fileExists);
    }
}