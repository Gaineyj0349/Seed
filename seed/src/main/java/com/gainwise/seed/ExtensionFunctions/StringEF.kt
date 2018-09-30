package com.gainwise.seed.ExtensionFunctions

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException

fun String.removeAllButNumbers(): String{
    return this.replace("[^0 -9]".toRegex(), "")
}

fun String.isValidSQLiteQuery(db: SQLiteDatabase): Boolean{
    var valid = false
    db.beginTransaction();
    try {
        if(this.startsWith("select",true)) {
            var c: Cursor = db.rawQuery(this, null)
        }else{
            db.execSQL(this)
        }
        valid = true
        db.setTransactionSuccessful();
    } catch (e: SQLiteException){
        valid = false
    }finally {
        db.endTransaction();
    }
    return valid
}