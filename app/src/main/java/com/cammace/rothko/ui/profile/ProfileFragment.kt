package com.cammace.rothko.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cammace.rothko.R
import com.cammace.rothko.databinding.HomeFragmentBinding
import com.cammace.rothko.databinding.ProfileFragmentBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: ProfileFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ProfileFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}
