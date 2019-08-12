package com.rao.com.idealarchitecture.ui.main.post

import android.os.Bundle
import com.rao.com.idealarchitecture.R
import com.rao.com.idealarchitecture.ui.main.base.BaseActivity
import com.rao.com.idealarchitecture.util.extension.addFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(R.id.content_frame, :: PostFragment)

    }
}
