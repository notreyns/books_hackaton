package com.hackaton.newbooks.ui.student.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hackaton.domain.model.ReserveStatus
import com.hackaton.domain.model.ReservedItem
import com.hackaton.newbooks.R
import com.hackaton.newbooks.databinding.RowReservedItemsBinding
import com.hackaton.newbooks.ui.extensions.setImageByUrl

class ReservedItemsAdapter :
    RecyclerView.Adapter<ReservedItemsAdapter.ViewPagerViewHolder>() {

    private var items  = mutableListOf<ReservedItem>()

    fun addItems(list: Collection<ReservedItem>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding = RowReservedItemsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.setData(items[position])
    }

    inner class ViewPagerViewHolder(val binding: RowReservedItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(model: ReservedItem) {
            binding.cartImage.setImageByUrl(model.book.image, R.drawable.book_placeholder_small)
            binding.tvCategory.text = model.book.category
            binding.tvStatus.text = model.status.message
            binding.tvTitle.text = model.book.title

            when(model.status){
                ReserveStatus.RESERVED -> {
                    binding.tvStatus.backgroundTintList = (binding.tvStatus.context.resources.getColorStateList(
                        R.color.green));
                    binding.substatus.text = "Дата возврата :\n ${model.date_to}"
                }
                ReserveStatus.RETURNED ->{
                    binding.tvStatus.backgroundTintList = (binding.tvStatus.context.resources.getColorStateList(
                        R.color.gray));
                    binding.substatus.text = ""
                }
                ReserveStatus.EXPIRED -> {
                    binding.tvStatus.backgroundTintList = (binding.tvStatus.context.resources.getColorStateList(
                        R.color.red));
                    binding.substatus.text = "Просрочена дата возрата"
                }
            }
        }
    }
}