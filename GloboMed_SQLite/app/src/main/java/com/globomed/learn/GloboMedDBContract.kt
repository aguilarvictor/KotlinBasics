package com.globomed.learn

import android.provider.BaseColumns
import android.provider.BaseColumns._ID
import android.provider.Contacts.SettingsColumns.KEY

object GloboMedDbContract {

    /*
    * Object type, it is a singleton class.
    * Constants for the table name and column names.
    */
    object EmployeeEntry : BaseColumns {
        const val TABLE_NAME = "employee"
        const val COLUMN_ID = _ID
        const val COLUMN_NAME = "name"
        const val COLUMN_DOB = "dob"
        const val COLUMN_DESIGNATION = "designation"

        /*
* Query to create table according to Contract class.
*/
        const val SQL_CREATE_ENTRIES: String =
            "CREATE TABLE ${TABLE_NAME} (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "${COLUMN_NAME} TEXT NOT NULL, " +
                    "${COLUMN_DOB} INTEGER NOT NULL, " +
                    "${COLUMN_DESIGNATION} TEXT NOT NULL)"

        /*
        * Query to drop the table
        */
        const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS ${TABLE_NAME}"

    }
}
