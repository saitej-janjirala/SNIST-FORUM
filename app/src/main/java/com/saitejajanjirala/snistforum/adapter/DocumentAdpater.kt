package com.saitejajanjirala.snistforum.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saitejajanjirala.snistforum.R
import com.saitejajanjirala.snistforum.models.Document
import com.saitejajanjirala.snistforum.models.FirebaseDocumentFile
import com.saitejajanjirala.snistforum.utils.Keys
import java.io.File

class DocumentAdpater(private val context:Context,
                      private val documentList:ArrayList<Document>,
                      private val type:String,
                      private val Fbdocuments:ArrayList<FirebaseDocumentFile>,
                      private val onDocumentItemClickListener: OnDocumentItemClickListener)
    :RecyclerView.Adapter<DocumentAdpater.DocumentViewHolder>(){
    inner class DocumentViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
            val docType:ImageView=itemView.findViewById(R.id.doc_type_image)
            val docName:TextView=itemView.findViewById(R.id.doc_name)
            val cancelBtn:ImageView=itemView.findViewById(R.id.cancel_button)
            val downloadBtn:ImageView=itemView.findViewById(R.id.download_button)
            val deleteBtn:ImageView=itemView.findViewById(R.id.delete_button)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.document_item,parent,false)
        return DocumentViewHolder(view)
    }

    override fun getItemCount():Int{
        if(type=="upload" || type=="download" ) {
            return documentList.size
        }
        return Fbdocuments.size
    }

    override fun onBindViewHolder(holder: DocumentViewHolder, position: Int) {
        if(type=="upload"){
            val mDoc=documentList[position]
            holder.cancelBtn.visibility=View.VISIBLE
            when(mDoc.type){
                "application/pdf"->{
                    holder.docType.setImageResource(R.drawable.ic_pdf)
                }
                "application/msword"->{
                    holder.docType.setImageResource(R.drawable.ic_word)
                }
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document"->{
                    holder.docType.setImageResource(R.drawable.ic_word)
                }
                "application/vnd.ms-powerpoint" ->{
                    holder.docType.setImageResource(R.drawable.ic_ppt)
                }
                "application/vnd.openxmlformats-officedocument.presentationml.presentation"->{
                    holder.docType.setImageResource(R.drawable.ic_ppt)
                }
            }
            holder.docName.text=mDoc.name
            holder.cancelBtn.setOnClickListener {
               if(position!= RecyclerView.NO_POSITION ){
                   onDocumentItemClickListener.onCancelClicked(position)
               }
            }
        }
        else if(type=="update"){
            val mDoc=Fbdocuments[position]
            setDelete(mDoc.isDeleted,holder.deleteBtn)
            holder.deleteBtn.visibility=View.VISIBLE
            when(mDoc.doctype){
                "application/pdf"->{
                    holder.docType.setImageResource(R.drawable.ic_pdf)
                }
                "application/msword"->{
                    holder.docType.setImageResource(R.drawable.ic_word)
                }
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document"->{
                    holder.docType.setImageResource(R.drawable.ic_word)
                }
                "application/vnd.ms-powerpoint" ->{
                    holder.docType.setImageResource(R.drawable.ic_ppt)
                }
                "application/vnd.openxmlformats-officedocument.presentationml.presentation"->{
                    holder.docType.setImageResource(R.drawable.ic_ppt)
                }
            }
            holder.docName.text=mDoc.docname
            holder.deleteBtn.setOnClickListener {
                if (position!=RecyclerView.NO_POSITION) {
                    onDocumentItemClickListener.onDeleteClicked(position, holder.deleteBtn)
                }
            }
        }
        else if(type=="view"){
            holder.downloadBtn.visibility=View.VISIBLE
            val mDoc=Fbdocuments[position]
            when(mDoc.doctype){
                "application/pdf"->{
                    holder.docType.setImageResource(R.drawable.ic_pdf)
                }
                "application/msword"->{
                    holder.docType.setImageResource(R.drawable.ic_word)
                }
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document"->{
                    holder.docType.setImageResource(R.drawable.ic_word)
                }
                "application/vnd.ms-powerpoint" ->{
                    holder.docType.setImageResource(R.drawable.ic_ppt)
                }
                "application/vnd.openxmlformats-officedocument.presentationml.presentation"->{
                    holder.docType.setImageResource(R.drawable.ic_ppt)
                }
            }
            val mimeTypes = arrayOf(
                "application/vnd.ms-powerpoint",
                "application/pdf",
                "application/msword",
                "application/vnd.openxmlformats-officedocument.presentationml.presentation",
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
            )
            val fileExtensionMap=HashMap<String,String>()
            fileExtensionMap[mimeTypes[0]]=".ppt"
            fileExtensionMap[mimeTypes[1]]=".pdf"
            fileExtensionMap[mimeTypes[2]]=".msword"
            fileExtensionMap[mimeTypes[3]]=".pptx"
            fileExtensionMap[mimeTypes[4]]=".wordx"
            val file = File(
                "${Keys.DOWNLOADS_FOLDER_PATH}/${mDoc.subjectname}/${mDoc.docname+"${fileExtensionMap[mDoc.doctype]}"}"
            )
            val exists=file.exists()
            if(exists){
                holder.downloadBtn.setImageResource(R.drawable.ic_check_mark)
            }
            else{
                holder.downloadBtn.setImageResource(R.drawable.ic_download)
            }
            holder.docName.text=mDoc.docname
            holder.downloadBtn.setOnClickListener {
                if (position != RecyclerView.NO_POSITION) {
                    onDocumentItemClickListener.onDownloadClicked(position, mDoc,exists)
                }
            }
            holder.itemView.setOnClickListener {
                if(position!=RecyclerView.NO_POSITION){
                    onDocumentItemClickListener.onItemClicked(position,
                        Document("","",Uri.parse("")),mDoc)
                }
            }
        }
        else if(type=="download"){
            val mDoc=documentList[position]
            when(mDoc.type){
                "application/pdf"->{
                    holder.docType.setImageResource(R.drawable.ic_pdf)
                }
                "application/msword"->{
                    holder.docType.setImageResource(R.drawable.ic_word)
                }
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document"->{
                    holder.docType.setImageResource(R.drawable.ic_word)
                }
                "application/vnd.ms-powerpoint" ->{
                    holder.docType.setImageResource(R.drawable.ic_ppt)
                }
                "application/vnd.openxmlformats-officedocument.presentationml.presentation"->{
                    holder.docType.setImageResource(R.drawable.ic_ppt)
                }
            }
            holder.docName.text=mDoc.name
            holder.itemView.setOnClickListener {
                onDocumentItemClickListener.onItemClicked(position,mDoc,
                    FirebaseDocumentFile("","","",""))
            }
        }
    }
    fun setDelete(isDeleted:Boolean,imageview:ImageView){
        if(isDeleted){
            imageview.setImageResource(R.drawable.ic_close_eyes)
        }
        else{
            imageview.setImageResource(R.drawable.ic_open)
        }
    }

    interface OnDocumentItemClickListener{
        fun onItemClicked(
            position: Int,
            document: Document,
            fbDocuemnt: FirebaseDocumentFile
        )
        fun onDeleteClicked(position: Int,imageView: ImageView)
        fun onCancelClicked(position: Int)
        fun onDownloadClicked(
            position: Int,
            fbDocument: FirebaseDocumentFile,
            fileExists: Boolean
        )
    }
}