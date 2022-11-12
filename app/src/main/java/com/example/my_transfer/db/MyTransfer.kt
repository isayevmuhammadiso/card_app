package com.example.my_transfer.db

import android.annotation.SuppressLint
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity
class MyTransfer {

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null

    var fromCardId:Int? =null
    var toCardId:Int? = null

    var Summa:Double? = null
    @SuppressLint("SimpleDateFormat")
    var date = SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(Date())

    constructor(fromCardId: Int?, toCardId: Int?, Summa: Double?) {
        this.fromCardId = fromCardId
        this.toCardId = toCardId
        this.Summa = Summa

    }

    constructor()
}