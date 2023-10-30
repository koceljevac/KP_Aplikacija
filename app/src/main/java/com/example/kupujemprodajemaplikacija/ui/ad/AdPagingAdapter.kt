package com.example.kupujemprodajemaplikacija.ui.ad

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kupujemprodajemaplikacija.R
import com.example.kupujemprodajemaplikacija.databinding.ListItemBinding
import com.example.kupujemprodajemaplikacija.models.Ad
import com.example.kupujemprodajemaplikacija.utils.Utils

class AdPagingAdapter(private val clickListener: AdClickListener) :
    PagingDataAdapter<Ad, AdPagingAdapter.AdViewHolder>(AdDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return AdViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdViewHolder, position: Int) {
        val ad = getItem(position)
        ad?.let {
            holder.bind(it)
        }
    }

    inner class AdViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(oglas: Ad) {
            binding.oglas = oglas
            binding.listener = clickListener
            binding.executePendingBindings()
        }
    }
}

class AdDiffCallback : DiffUtil.ItemCallback<Ad>() {
    override fun areItemsTheSame(oldItem: Ad, newItem: Ad): Boolean {
        return oldItem.ad_id == newItem.ad_id
    }

    override fun areContentsTheSame(oldItem: Ad, newItem: Ad): Boolean {
        return oldItem.ad_id == newItem.ad_id
    }
}

interface AdClickListener {
    fun onAdClick(ad: Ad)
}