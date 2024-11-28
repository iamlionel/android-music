package com.example.imooc_voice.ui.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.imooc_voice.databinding.FragmentMineBinding

class MineFragment : Fragment() {

    private lateinit var binding: FragmentMineBinding

    companion object {
        fun newInstance(): MineFragment {
            return MineFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMineBinding.inflate(inflater, container, false)
        return binding.root
    }
}