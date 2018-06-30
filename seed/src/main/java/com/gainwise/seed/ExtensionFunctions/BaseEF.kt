package com.gainwise.seed.ExtensionFunctions

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.inputmethod.InputMethodManager

//hides the keyboard
fun hideSoftKeyboard(activity: Activity){
    val inputMethodManager = activity.getSystemService(
            Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(
            activity.getCurrentFocus()!!.getWindowToken(), 0)
}


//copies a string to cliptray primary
fun copyToClipTray(context: Context, label: String, body: String) {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(label, body)
    clipboard.primaryClip = clip
}

