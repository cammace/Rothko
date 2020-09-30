package com.cammace.rothko.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cammace.rothko.R
import com.cammace.rothko.databinding.ProfileFragmentBinding
import com.cammace.rothko.databinding.SearchFragmentBinding

class SearchFragment : Fragment() {

    private lateinit var binding: SearchFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}
