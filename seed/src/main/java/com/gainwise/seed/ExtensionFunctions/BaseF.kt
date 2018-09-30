package com.gainwise.seed.ExtensionFunctions

import android.app.Activity
import android.content.*
import android.net.Uri
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

//convert stacktrace to String
fun Throwable.causeAndStackTraceToString(): String{
    val e = this
    val sb = StringBuilder("\n\ntimeInMillis: +${System.currentTimeMillis()} \n\nlocal message: ${e.localizedMessage}")
    for(el in e.stackTrace){
        sb.append(el.toString())
        sb.append("\n")
    }
    return sb.toString()
}

//start a basic activity
inline fun <reified T : Activity > Context.seedStartNewActivityBasic(){
    startActivity(Intent(this, T::class.java))
}

//start a cleartop activity
inline fun <reified T : Activity > Context.seedStartNewActivityClearTop(){
    val i = Intent(this, T::class.java)
    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    startActivity(i)
}

//start a string extra activity
inline fun <reified T : Activity > Context.seedStartActivityWithStringExtra(extraName: String, extraValue: String){
    val i = Intent(this, T::class.java)
    i.putExtra(extraName, extraValue)
    startActivity(i)
}

//launch youtube or site to watch the video
fun Context.watchYoutubeVideo(id: String) {
    val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
    val webIntent = Intent(Intent.ACTION_VIEW,
            Uri.parse("http://www.youtube.com/watch?v=$id"))
    try {
        this.startActivity(appIntent)
    } catch (ex: ActivityNotFoundException) {
        this.startActivity(webIntent)
    }

}

