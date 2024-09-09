package database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database : SQLiteOpenHelper {
    constructor(context: Context) : super(context, "pet.db", null, 1)

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE pets (id INTEGER PRIMARY KEY, name TEXT, age INTEGER, breed TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS pets")
        onCreate(db)
    }
}