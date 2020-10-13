package com.cammace.rothko.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cammace.rothko.core.results.Resource
import com.cammace.rothko.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private val viewModel: HomeViewModel by viewModels()
    private val adapter by lazy { ArtworkAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            adapter = this@HomeFragment.adapter
            setHasFixedSize(true)
        }

        viewModel.trendingArtwork.observe(
            viewLifecycleOwner,
            { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        adapter.submitList(resource.data)
                    }
                    Resource.Status.LOADING -> {
                        // TODO
                    }
                    else -> {
                        // TODO
                    }
                }
            }
        )
    }
}
