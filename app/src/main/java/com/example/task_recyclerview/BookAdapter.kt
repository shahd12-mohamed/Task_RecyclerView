package com.example.task_recyclerview

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.content.res.ColorStateList
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task_recyclerview.databinding.ItemBookBinding

class BookAdapter(private val books: MutableList<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book, onDelete: (Int) -> Unit) {
            binding.tvTitle.text = book.title
            binding.tvAuthor.text = book.author
            binding.tvRating.rating = book.rating

            val resourceId = binding.ivImage.context.resources.getIdentifier(
                book.image, "drawable", binding.ivImage.context.packageName
            )

            Glide.with(binding.ivImage.context)
                .load(resourceId)
                .into(binding.ivImage)

            setRatingBarColor(binding.tvRating, book.rating)

            binding.tvRating.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
                if (fromUser) {
                    // Update the rating dynamically
                    book.rating = rating
                    // Update the color dynamically based on rating
                    setRatingBarColor(ratingBar, rating)
                }
            }

            // Set the delete button click listener
            binding.ivDelete.setOnClickListener {
                onDelete(adapterPosition)
            }
        }

        private fun setRatingBarColor(ratingBar: RatingBar, rating: Float) {
            val color = if (rating > 0) {
                ratingBar.context.getColor(R.color.orange)
            } else {
                ratingBar.context.getColor(R.color.grey)
            }
            ratingBar.progressTintList = ColorStateList.valueOf(color)
        }

        companion object {
            fun from(parent: ViewGroup): BookViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemBookBinding.inflate(layoutInflater, parent, false)
                return BookViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book) { adapterPosition ->
            // Remove the book from the list and notify the adapter
            books.removeAt(adapterPosition)
            notifyItemRemoved(adapterPosition)
            notifyItemRangeChanged(adapterPosition, books.size)
        }
    }

    override fun getItemCount(): Int = books.size
}
