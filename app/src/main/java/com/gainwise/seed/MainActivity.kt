package com.gainwise.seed

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gainwise.seed.ExtensionFunctions.getLocaleDateString
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iv.minZoom = .5f
        iv.maxZoom = 1000f
        tv.text = System.currentTimeMillis().getLocaleDateString()
    }
}
