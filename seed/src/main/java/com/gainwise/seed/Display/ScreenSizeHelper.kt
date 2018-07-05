package com.gainwise.seed.Display

import android.app.Activity
import android.content.res.Resources
import android.graphics.Point

class ScreenSizeHelper(activity: Activity) {

    var displayWidth: Int = 0
        internal set
    var displayHeight: Int = 0
        internal set

    init {
        val display = activity.windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)

        //below is px
        displayWidth = size.x
        displayHeight = size.y

    }

    fun pxToDp(px: Int): Int {

        return (px / Resources.getSystem().displayMetrics.density).toInt()
    }

    fun dpToPx(dp: Int): Int {

        return Math.round(dp * Resources.getSystem().displayMetrics.density)
    }
}