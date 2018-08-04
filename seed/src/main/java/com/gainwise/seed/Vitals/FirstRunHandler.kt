package com.gainwise.seed.Vitals

import android.content.Context

open class FirstRunHandler (val context: Context, firstRunner: FirstRunner) {
    init{
        val pref = context.getSharedPreferences("FIRSTRUN12321", Context.MODE_PRIVATE)
        val editor = pref.edit()
        val first: String? = pref.getString("FirstRunKey", null)
        if (first == null){
            firstRunner.execute()
            editor.putString("FirstRunKey", "no")
            editor.apply()
        }
    }
}

interface FirstRunner{
    fun execute()
}

