package com.globomed.learn

import com.globomed.learn.GloboMedDbContract.EmployeeEntry

object DataManager {
    fun fetchAllEmployees(databaseHelper: DatabaseHelper): ArrayList<Employee>{
        val employees = ArrayList<Employee>()

        /*
        * Open database connection
        */
        val db = databaseHelper.readableDatabase

        /*
        * Create the array of column names
        */
        val columns = arrayOf(
            EmployeeEntry.COLUMN_ID,
            EmployeeEntry.COLUMN_NAME,
            EmployeeEntry.COLUMN_DOB,
            EmployeeEntry.COLUMN_DESIGNATION
        )

        /*
        * Call query() function to fetch the data
        */
        val cursor = db.query(
            EmployeeEntry.TABLE_NAME,
            columns,
            null,
            null,
            null,
            null,
            null
        )

        /*
        * Fetch the position of the columns
        */
        val idPos = cursor.getColumnIndex(EmployeeEntry.COLUMN_ID)
        val namePos = cursor.getColumnIndex(EmployeeEntry.COLUMN_NAME)
        val dobPos = cursor.getColumnIndex(EmployeeEntry.COLUMN_DOB)
        val designationPos = cursor.getColumnIndex(EmployeeEntry.COLUMN_DESIGNATION)

        /*
        * Cursor initial position is -1. With moveToNext it will be moved to first position.
        * Iterate to each row, while the cursor can move to a next position
        * until the end of the cursor is reached.
        *
        * Then, fetch the column values and add to employee array
        */
        while (cursor.moveToNext()){
            val id = cursor.getString(idPos)
            val name = cursor.getString(namePos)
            val dob = cursor.getLong(dobPos)
            val designation = cursor.getString(designationPos)

            employees.add(Employee(id, name, dob, designation))
        }

        cursor.close()
        return employees
    }

    fun fetchEmployee(databaseHelper: DatabaseHelper, empId: String) : Employee?{
        /* Open database connection */
        val db  = databaseHelper.readableDatabase
        var employee: Employee? = null

        /* Create the array of column names, except for ID that is a given parameter */
        val columns = arrayOf(
            EmployeeEntry.COLUMN_NAME,
            EmployeeEntry.COLUMN_DOB,
            EmployeeEntry.COLUMN_DESIGNATION
        )

        /* Specify the selection and selectionArgs for the filter query */
        val selection = EmployeeEntry.COLUMN_ID + " LIKE ? "
        val selectionArgs = arrayOf(empId)

        /* Call query function with the selection filter */
        val cursor = db.query(
            EmployeeEntry.TABLE_NAME,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null
        )

        /* Fetch the position of the columns */
        val namePos = cursor.getColumnIndex(EmployeeEntry.COLUMN_NAME)
        val dobPos = cursor.getColumnIndex(EmployeeEntry.COLUMN_DOB)
        val designationPos = cursor.getColumnIndex(EmployeeEntry.COLUMN_DESIGNATION)


        /* Fetch the column values, except for ID */
        while (cursor.moveToNext()){
            val name = cursor.getString(namePos)
            val dob = cursor.getLong(dobPos)
            val designation = cursor.getString(designationPos)

            employee = Employee(empId, name, dob, designation)
        }

        db.close()

        return employee
    }
}