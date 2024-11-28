package com.example.imooc_voice.ui.friend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.imooc_voice.databinding.FragmentFriendBinding

class FriendFragment : Fragment() {

    private lateinit var binding: FragmentFriendBinding

    companion object {
        fun newInstance(): FriendFragment {
            return FriendFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFriendBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}