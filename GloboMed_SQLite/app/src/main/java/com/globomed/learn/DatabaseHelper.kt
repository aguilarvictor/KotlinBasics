package com.globomed.learn

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(
   context: Context?
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    /*
    *  Called when the database is created for the first time.
    *  Where the creation of tables and population of tables happen.
    */
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(GloboMedDbContract.SQL_CREATE_ENTRIES)
    }

    /*
    * Called when the database needs to be upgraded.
    *
    */
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(GloboMedDbContract.SQL_DROP_TABLE)
        onCreate(db)
    }

    /*
    * Called to do a downgrade.
    * If not overridden, any downgrade request will be rejected and exception will be thrown.
    */
    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }

    /*
    * Called when schema is created, updated or downgraded.
    */
    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
    }

    /*
            * Constants for the table name and version.
            * Version has to be updated everytime schema is modified.
            */
    companion object{
        const val DATABASE_NAME = "globomed.db"
        const val DATABASE_VERSION = 1
    }
}
