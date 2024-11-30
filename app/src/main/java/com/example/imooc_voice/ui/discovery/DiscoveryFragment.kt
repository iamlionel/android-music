package com.example.imooc_voice.ui.discovery

import com.example.imooc_voice.R
import com.example.imooc_voice.databinding.FragmentDiscoveryBinding
import com.example.lib_common_ui.base.BaseFragment

class DiscoveryFragment : BaseFragment(R.layout.fragment_discovery) {

    private lateinit var binding: FragmentDiscoveryBinding

    companion object {
        fun newInstance(): DiscoveryFragment {
            return DiscoveryFragment()
        }
    }
}