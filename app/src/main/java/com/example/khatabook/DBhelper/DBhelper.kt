package com.example.khatabook.DBhelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.khatabook.TransactionModal

class DBhelper(
    context: Context?
) : SQLiteOpenHelper(context, "Expense.db", null, 1) {

    var TABLE_NAME = "trans"

    override fun onCreate(db: SQLiteDatabase?) {

        var sql =
            "CREATE TABLE $TABLE_NAME(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT, amt INTEGER ,category TEXT , note TEXT ,time TEXT,isexpense INTEGER)"
        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {


    }

    fun


            addTrans(trans: TransactionModal) {
        var db = writableDatabase
        var values = ContentValues().apply {
            trans.apply {

                put("amt", amt)
                put("category", category)
                put("note", note)
                put("time", time)
                put("isexpense", isexpense)
            }
        }
        db.insert("trans", null, values)
    }

    fun getTransaction(): ArrayList<TransactionModal> {

        var transList = ArrayList<TransactionModal>()
        var db = readableDatabase
        var sql = "SELECT * FROM trans"
        var cursor = db.rawQuery(sql, null)
        cursor.moveToFirst()

        for (i in 0..cursor.count - 1) {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var amt = cursor.getInt(2)
            var category = cursor.getString(3)
            var note = cursor.getString(4)
            var time = cursor.getString(5)
            var isExpense = cursor.getInt(6)
            var data = TransactionModal(id,amt,category,note,isExpense,time)
            //    var data = TransactionModal(id, name, amt, category, note,time, isExpense)
            transList.add(data)
            cursor.moveToNext()
        }
        return transList


    }

    fun deleteTransaction(id: Int) {
        var db = writableDatabase



        //sqlqurey
        var sql = "DELETE FROM trans WHERE id='$id'"
        db.execSQL(sql)


    }

    fun updateTransaction(trans: TransactionModal) {

        var db = writableDatabase
        var values = ContentValues().apply {
            trans.apply {

                put("amt", amt)
                put("category", category)
                put("note", note)
                put("time", time)
                put("isexpense", isexpense)
            }
        }
        db.update(TABLE_NAME, values, "id=${trans.id}", null)
    }
}