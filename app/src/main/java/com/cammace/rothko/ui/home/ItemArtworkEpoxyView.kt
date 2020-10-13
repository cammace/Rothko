package com.cammace.rothko.ui.home

import coil.load
import com.cammace.rothko.R
import com.cammace.rothko.databinding.ItemArtworkBinding
import com.cammace.rothko.utils.ViewBindingKotlinModel

// This does not require annotations or annotation processing.
// The data class is required to generated equals/hashcode which Epoxy needs for diffing.
// Views are easily declared via property delegates
data class ItemArtworkEpoxyView(
    val imageUrl: String?,
    val title: String?
) : ViewBindingKotlinModel<ItemArtworkBinding>(R.layout.item_artwork) {
    override fun ItemArtworkBinding.bind() {
        artworkImageView.load(imageUrl)
        titleTextView.text = title
    }
}
