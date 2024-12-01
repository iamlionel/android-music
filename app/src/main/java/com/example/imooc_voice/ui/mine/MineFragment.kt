package com.example.imooc_voice.ui.mine

import MineViewModel
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.imooc_voice.R
import com.example.imooc_voice.databinding.FragmentMineBinding
import com.example.lib_common_ui.base.BaseFragment
import com.example.lib_common_ui.ext.binding

class MineFragment : BaseFragment(R.layout.fragment_mine) {

    private val binding by binding(FragmentMineBinding::bind)

    private val viewModel: MineViewModel by viewModels()

    companion object {
        fun newInstance(): MineFragment {
            return MineFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.bannerData.observe(viewLifecycleOwner) { banners ->
            for (banner in banners.data) {
                Log.d("mine", banner.toString())
            }
        }
        viewModel.getBanner()
    }
}
