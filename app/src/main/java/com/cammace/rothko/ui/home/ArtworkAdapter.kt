package com.cammace.rothko.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.cammace.rothko.R
import com.cammace.rothko.core.data.model.TrendingArtwork
import com.cammace.rothko.databinding.ItemArtworkBinding

class ArtworkAdapter : ListAdapter<TrendingArtwork, ArtworkAdapter.ViewHolder>(ArtworkDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_artwork, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artwork = getItem(position)
        holder.bind(artwork)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemArtworkBinding.bind(view)

        fun bind(artwork: TrendingArtwork) {
            binding.artworkImageView.load(artwork.imageUrl)
            binding.titleTextView.text = artwork.artist
        }
    }
}

private class ArtworkDiffCallback : DiffUtil.ItemCallback<TrendingArtwork>() {

    override fun areItemsTheSame(oldItem: TrendingArtwork, newItem: TrendingArtwork): Boolean {
        // TODO should really be handling diff using IDs
        return oldItem.imageUrl == newItem.imageUrl
    }

    override fun areContentsTheSame(oldItem: TrendingArtwork, newItem: TrendingArtwork): Boolean {
        return oldItem == newItem
    }
}
