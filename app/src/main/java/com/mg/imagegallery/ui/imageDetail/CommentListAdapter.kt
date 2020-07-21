package com.mg.imagegallery.ui.imageDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mg.imagegallery.R
import com.mg.imagegallery.data.database.Comment
import com.mg.imagegallery.databinding.ListItemCommentBinding


class CommentListAdapter(private val comments: List<Comment>) :
    RecyclerView.Adapter<CommentListAdapter.CommentItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentItemViewHolder {
        return CommentItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_comment,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = comments.size

    override fun onBindViewHolder(holder: CommentItemViewHolder, position: Int) {
        holder.listItemCommentBinding.comment = comments[position]
    }

    inner class CommentItemViewHolder(val listItemCommentBinding: ListItemCommentBinding) :
        RecyclerView.ViewHolder(listItemCommentBinding.root)

}