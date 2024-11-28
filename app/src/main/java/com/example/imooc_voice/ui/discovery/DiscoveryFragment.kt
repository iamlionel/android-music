package com.example.imooc_voice.ui.discovery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.imooc_voice.databinding.FragmentDiscoveryBinding

class DiscoveryFragment : Fragment() {

    private lateinit var binding: FragmentDiscoveryBinding

    companion object {
        fun newInstance(): DiscoveryFragment {
            return DiscoveryFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDiscoveryBinding.inflate(inflater,container,false)
        return binding.root
    }
}