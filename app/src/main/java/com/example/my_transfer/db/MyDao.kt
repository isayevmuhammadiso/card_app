package com.example.my_transfer.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MyDao {

    @Insert
    fun addCard(card: MyCard)


    @Insert
    fun addTransfer(myTransfer: MyTransfer)

    @Query("select * from mycard")
    fun getcards():List<MyCard>

    @Query("select * from mytransfer")
    fun getTransfers():List<MyTransfer>

}