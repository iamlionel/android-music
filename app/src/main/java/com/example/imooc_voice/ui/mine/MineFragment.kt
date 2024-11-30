package com.example.imooc_voice.ui.mine

import com.example.imooc_voice.R
import com.example.imooc_voice.databinding.FragmentMineBinding
import com.example.lib_common_ui.base.BaseFragment
import com.example.lib_common_ui.ext.binding

class MineFragment : BaseFragment(R.layout.fragment_mine) {

    private val binding by binding(FragmentMineBinding::bind)

    companion object {
        fun newInstance(): MineFragment {
            return MineFragment()
        }
    }
}
