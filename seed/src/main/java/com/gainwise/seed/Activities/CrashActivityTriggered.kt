package com.gainwise.seed.Activities

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gainwise.seed.R
import kotlinx.android.synthetic.main.activity_crash_triggered.*

class CrashActivityTriggered : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crash_triggered)
        val prefs = getSharedPreferences("CRASHBLOCK", Context.MODE_PRIVATE);
        val crashReport: String? = prefs.getString("CRASH", null)
        val editor = getSharedPreferences("CRASHBLOCK", Context.MODE_PRIVATE).edit();
        editor.putBoolean("CRASHED", false)
        editor.apply()
        fab.setOnClickListener { view ->
           finish()
        }
    }

}
