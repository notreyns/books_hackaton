package com.hackaton.newbooks.ui.catalog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hackaton.domain.model.Book
import com.hackaton.newbooks.R
import com.hackaton.newbooks.databinding.RowBooksBinding
import com.hackaton.newbooks.ui.extensions.setImageByUrl

class BooksAdapter:
    RecyclerView.Adapter<BooksAdapter.ViewPagerViewHolder>() {

    private var items  = mutableListOf<Book>()

    fun addItems(list: Collection<Book>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding = RowBooksBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.setData(items[position])
    }

    inner class ViewPagerViewHolder(val binding: RowBooksBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(model: Book) {
            binding.cartImage.setImageByUrl(model.image, R.drawable.book_placeholder_small)
            binding.tvCategory.text = model.category
            binding.tvTitle.text = model.title
            binding.tvAuthor.text = model.author
            if(model.reserved_c >= model.count){
                binding.substatus.text = "Недоступно"
            }else{
                binding.substatus.text = "Доступно :\n${model.count - model.reserved_c}"
            }
        }
    }
}