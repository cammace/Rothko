package com.cammace.rothko.ui.home

import com.airbnb.epoxy.TypedEpoxyController
import com.cammace.rothko.core.data.model.TrendingArtwork
import com.cammace.rothko.core.results.Resource

class ArtworkEpoxyController : TypedEpoxyController<Resource<List<TrendingArtwork>>>() {
    override fun buildModels(resource: Resource<List<TrendingArtwork>>) {
        when (resource.status) {
            Resource.Status.SUCCESS -> {
                spanCount = 2
                resource.data?.forEach {
                    artworkItemEpoxyView {
                        id(it.imageUrl)
                        artwork(it)
                    }
                }
            }
            Resource.Status.LOADING -> {
                // TODO
            }
            else -> {
                // TODO
            }
        }
    }
}
