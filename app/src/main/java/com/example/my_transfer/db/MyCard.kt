package com.example.my_transfer.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MyCard {

    @PrimaryKey (autoGenerate = true)
    var id:Int? = null

    var name:String? = null
    var cardNumber:Long? = null

    constructor(name: String?, cardNumber: Long?) {
        this.name = name
        this.cardNumber = cardNumber
    }

    constructor()
}