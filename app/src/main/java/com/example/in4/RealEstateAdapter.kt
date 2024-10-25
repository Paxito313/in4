package com.example.in4.ui.mostraritems

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.in4.R
import com.example.in4.data.RealEstate
import com.example.in4.databinding.ItemListaContenidoBinding

class RealEstateAdapter :
    ListAdapter<RealEstate, RealEstateAdapter.RealEstateViewHolder>(RealEstateComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RealEstateViewHolder {
        val binding = ItemListaContenidoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RealEstateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RealEstateViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class RealEstateViewHolder(private val binding: ItemListaContenidoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RealEstate) {
            binding.itemId.text = item.id
            binding.itemTipo.text = item.type
            binding.itemPrecio.text = item.price.toString()
            Glide.with(binding.itemImgSrc.context)
                .load(item.img_src)
                .apply(RequestOptions().placeholder(R.drawable.placeholder).error(R.drawable.error_image))
                .into(binding.itemImgSrc)
        }
    }

    class RealEstateComparator : DiffUtil.ItemCallback<RealEstate>() {
        override fun areItemsTheSame(oldItem: RealEstate, newItem: RealEstate): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RealEstate, newItem: RealEstate): Boolean {
            return oldItem == newItem
        }
    }
}
