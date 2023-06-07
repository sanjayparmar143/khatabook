package com.example.khatabook

class TransactionModal {
    var id: Int = 0
    var amt: Int = 0
    lateinit var category: String
    lateinit var note: String
    var isexpense: Int = 0
    lateinit var time :String

    constructor(
        id: Int, amt: Int, category: String, note: String, isexpense: Int, time: String
    ) {
        this.id = id
        this.amt = amt
        this.category = category
        this.note = note
        this.time = time
        this.isexpense = isexpense

    }
}