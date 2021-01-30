package com.saitejajanjirala.snistforum.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saitejajanjirala.snistforum.R
import com.saitejajanjirala.snistforum.db.entities.AddedSubject

class SubjectsAdapter(
    val context: Context,
    val subjectsList: ArrayList<AddedSubject>,
    val type: String,
    val onitemClickListener: onItemClickListener
) : RecyclerView.Adapter<SubjectsAdapter.SubjectsViewHolder>() {
    inner class SubjectsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectName: TextView = itemView.findViewById(R.id.subject_name)
        val subjectDelete: ImageView = itemView.findViewById(R.id.delete_subject)
        val addSubject: ImageView = itemView.findViewById(R.id.add_subject)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.subjects_layout, parent, false)
        return SubjectsViewHolder(view)
    }

    override fun getItemCount() = subjectsList.size

    override fun onBindViewHolder(holder: SubjectsViewHolder, position: Int) {
        val obj = subjectsList[position]
        holder.subjectName.text = obj.subjectName
        holder.itemView.setOnClickListener {
            if(position!=RecyclerView.NO_POSITION) {
                onitemClickListener.onItemClicked(position)
            }
        }
        if (type=="home") {
            holder.subjectDelete.visibility = View.VISIBLE
            holder.subjectDelete.setOnClickListener {
                if(position!=RecyclerView.NO_POSITION) {
                    onitemClickListener.onDeleteClicked(position)
                }
            }
        } else if (type=="add") {
            holder.addSubject.visibility = View.VISIBLE
            holder.addSubject.setOnClickListener {
                if(position!=RecyclerView.NO_POSITION){
                    onitemClickListener.onAddClicked(position)
                }
            }
        }
        else if(type=="download"){
            holder.itemView.setOnClickListener {
                if(position!=RecyclerView.NO_POSITION){
                    onitemClickListener.onItemClicked(position)
                }
            }

        }

    }

    interface onItemClickListener {
        fun onItemClicked(position: Int)
        fun onDeleteClicked(position: Int)
        fun onAddClicked(position: Int)
    }
}