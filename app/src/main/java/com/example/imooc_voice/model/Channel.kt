package com.example.imooc_voice.model

sealed class Channel(val name: String) {
    data object MY : Channel("我的")
    data object DISCOVERY : Channel("发现")
    data object FRIEND : Channel("朋友")
    data object VIDEO : Channel("Video")
}

