package com.example.imooc_voice.ui.mine

// Response wrapper class
data class BannerResponse(
    val data: List<BannerItem>,
    val errorCode: Int,
    val errorMsg: String
)

// Banner item data class
data class BannerItem(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)