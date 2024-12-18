package com.example.imooc_voice.ui.home

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import androidx.activity.viewModels
import com.example.imooc_voice.databinding.ActivityHomeBinding
import com.example.imooc_voice.model.Channel
import com.example.imooc_voice.ui.home.adapter.HomePagerAdapter
import com.example.lib_common_ui.base.BaseActivity
import com.example.lib_common_ui.ext.binding
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView

class HomeActivity : BaseActivity() {

    //todo viewmodel

    private val binding by binding(ActivityHomeBinding::inflate)

    private lateinit var adapter: HomePagerAdapter

    private val viewModel: HomeViewModel by viewModels()

    companion object {
        private val channels = arrayOf(Channel.MY, Channel.DISCOVERY, Channel.FRIEND)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.ivToggle.setOnClickListener {
            if (binding.drawer.isDrawerOpen(Gravity.LEFT)) {
                binding.drawer.closeDrawer(Gravity.LEFT)
            } else {
                binding.drawer.openDrawer(Gravity.LEFT)
            }
        }

        adapter = HomePagerAdapter(supportFragmentManager, channels)
        binding.vpContent.adapter = adapter
        initMagicIndicator()
    }

    private fun initMagicIndicator() {
        binding.indicator.setBackgroundColor(Color.WHITE)
        val commonNavigator = CommonNavigator(this)
        commonNavigator.isAdjustMode = true
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return channels.size
            }

            override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
                val titleView = SimplePagerTitleView(context)
                titleView.text = channels[index].name
                titleView.textSize = 19f
                titleView.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                titleView.normalColor = Color.parseColor("#999999")
                titleView.selectedColor = Color.parseColor("#333333")
                titleView.setOnClickListener {
                    binding.vpContent.currentItem = index
                }
                return titleView
            }

            override fun getIndicator(context: Context?): IPagerIndicator? {
                return null
            }

            override fun getTitleWeight(context: Context?, index: Int): Float {
                return 1.0f
            }
        }
        binding.indicator.navigator = commonNavigator
        ViewPagerHelper.bind(binding.indicator, binding.vpContent)
    }
}