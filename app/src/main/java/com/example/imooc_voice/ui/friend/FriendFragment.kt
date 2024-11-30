package com.example.imooc_voice.ui.friend

import com.example.imooc_voice.R
import com.example.imooc_voice.databinding.FragmentFriendBinding
import com.example.lib_common_ui.base.BaseFragment

class FriendFragment : BaseFragment(R.layout.fragment_friend) {

    private lateinit var binding: FragmentFriendBinding

    companion object {
        fun newInstance(): FriendFragment {
            return FriendFragment()
        }
    }
}