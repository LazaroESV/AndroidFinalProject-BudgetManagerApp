package com.example.personalbudgetmanagerapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "transactions")
data class Transaction(

    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    val title: String,

    val amount: Double,

    val category: String,

    val date: String,

    val type: TransactionType
)