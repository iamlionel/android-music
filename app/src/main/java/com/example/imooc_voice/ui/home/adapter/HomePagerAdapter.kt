package com.example.imooc_voice.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.imooc_voice.model.Channel
import com.example.imooc_voice.ui.discovery.DiscoveryFragment
import com.example.imooc_voice.ui.friend.FriendFragment
import com.example.imooc_voice.ui.mine.MineFragment
import com.example.imooc_voice.ui.video.VideoFragment

class HomePagerAdapter(fragmentManager: FragmentManager, private val channels: Array<Channel>) :
    FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return channels.size
    }

    override fun getItem(position: Int): Fragment {
        return when (channels[position]) {
            is Channel.MY -> MineFragment.newInstance()
            is Channel.DISCOVERY -> DiscoveryFragment.newInstance()
            is Channel.FRIEND -> FriendFragment.newInstance()
            is Channel.VIDEO -> VideoFragment.newInstance()
        }
    }
}