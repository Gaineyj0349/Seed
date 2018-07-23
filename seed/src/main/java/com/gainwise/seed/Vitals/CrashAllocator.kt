package com.gainwise.seed.Vitals

import android.content.Context
import com.gainwise.seed.ExtensionFunctions.causeAndStackTraceToString

class CrashAllocator(//declare variable for object imlementing interface
        private val ourCrashHandler: Crashable, context: Context, prefsNameToSaveStackTrace: String) {

    //declare variable for uncaught exception handler
    private var defaultCrashHandler: Thread.UncaughtExceptionHandler? = null

    private val TUEhandler = Thread.UncaughtExceptionHandler { thread, ex ->

        val prefs = context.getSharedPreferences(prefsNameToSaveStackTrace, Context.MODE_PRIVATE).edit();
        prefs.putString("CRASH", ex.causeAndStackTraceToString())
        prefs.apply()
        //Code passed via the Crashable interface in the constructor is executed
        ourCrashHandler.executeOnCrash()

        // re-throw critical exception further to the os (important)
        defaultCrashHandler!!.uncaughtException(thread, ex)
    }

    init {

        // uncaught exception handler variable initialized
        defaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler()

        // setup handler for uncaught exception
        Thread.setDefaultUncaughtExceptionHandler(TUEhandler)
    }//in our new Handler, the interface method will execute


}

interface Crashable {
    fun executeOnCrash()
}
