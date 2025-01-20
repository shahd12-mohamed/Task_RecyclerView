package com.example.task_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task_recyclerview.databinding.ItemBookBinding

class BookAdapter (val books: List<Book>) :
     ListAdapter<Book, RecyclerView.ViewHolder>(BookDiffUtilCallback()) {

     class BookViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
         companion object {
             fun from(parent: ViewGroup): BookViewHolder {
                 val layoutInflater = LayoutInflater.from(parent.context)
                 val binding = ItemBookBinding.inflate(layoutInflater, parent, false)
                 return BookViewHolder(binding)
             }
         }
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
         return BookViewHolder.from(parent)
     }

     override fun getItemCount(): Int {
         return books.size
     }

     override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
         val book = books[position]
         if (holder is BookViewHolder) {

             holder.binding.tvTitle.text = book.title
             holder.binding.tvAuthor.text = book.author
             holder.binding.tvRating.rating = book.rating
             // Load image from drawable
             val resourceId = holder.binding.ivImage.context.resources.getIdentifier(
                 book.image, "drawable", holder.binding.ivImage.context.packageName
             )

             Glide.with(holder.binding.ivImage.context)
                 .load(resourceId) // Load image from drawable resource
                 .into(holder.binding.ivImage)
         }
     }

     class BookDiffUtilCallback : DiffUtil.ItemCallback<Book>() {
         override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
             return oldItem == newItem
         }

         override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
             return oldItem == newItem
         }
     }
 }