package com.globomed.learn

import android.provider.BaseColumns

object GloboMedDbContract {

    /*
    * Query to create table according to Contract class.
    */
    const val SQL_CREATE_ENTRIES: String =
        "CREATE TABLE ${EmployeeEntry.TABLE_NAME} (" +
                "${EmployeeEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTO INCREMENT," +
                "${EmployeeEntry.COLUMN_NAME} TEXT NOT NULL," +
                "${EmployeeEntry.COLUMN_DOB} INTEGER NOT NULL," +
                "${EmployeeEntry.COLUMN_DESIGNATION} TEXT NOT NULL)"

    /*
    * Query to drop the table
    */
    const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS ${EmployeeEntry.TABLE_NAME}"

    /*
    * Object type, it is a singleton class.
    * Constants for the table name and column names.
    */
    object EmployeeEntry : BaseColumns {
        const val TABLE_NAME = "employee"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_DOB = "dob"
        const val COLUMN_DESIGNATION = "designation"
    }
}
