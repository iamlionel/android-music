package com.example.lib_common_ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lib_common_ui.utils.StatusBarUtil

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.transparencyBar(this)
    }
}