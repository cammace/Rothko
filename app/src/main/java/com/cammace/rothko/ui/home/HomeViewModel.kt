package com.cammace.rothko.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.cammace.rothko.core.data.ArtworkRepository
import com.cammace.rothko.core.data.model.TrendingArtwork
import com.cammace.rothko.core.results.Resource

class HomeViewModel @ViewModelInject constructor(
    artworkRepository: ArtworkRepository
) : ViewModel() {

    val trendingArtwork: LiveData<Resource<List<TrendingArtwork>>> = liveData {
        emitSource(artworkRepository.getTrendingArtwork().asLiveData())
    }
}
