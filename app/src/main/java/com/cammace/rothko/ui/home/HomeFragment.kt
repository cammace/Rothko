package com.cammace.rothko.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cammace.rothko.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private val viewModel: HomeViewModel by viewModels()
    private val controller: ArtworkEpoxyController by lazy { ArtworkEpoxyController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            setController(controller)
        }

        viewModel.trendingArtwork.observe(
            viewLifecycleOwner,
            { resource ->
                controller.setData(resource)
            }
        )
    }
}
