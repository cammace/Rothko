package com.cammace.rothko.ui.home

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import coil.load
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.cammace.rothko.core.data.model.TrendingArtwork
import com.cammace.rothko.databinding.ItemArtworkBinding
import com.google.android.material.card.MaterialCardView

@ModelView(saveViewState = true, autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class ArtworkItemEpoxyView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val binding: ItemArtworkBinding = ItemArtworkBinding.inflate(LayoutInflater.from(context), this, true)

    @ModelProp
    fun setArtwork(artwork: TrendingArtwork) {
        binding.titleTextView.text = artwork.title
        binding.artistTextView.text = artwork.artist
        binding.priceTextView.text = artwork.displayPrice
        binding.artworkImageView.load(artwork.imageUrl)
    }
}
