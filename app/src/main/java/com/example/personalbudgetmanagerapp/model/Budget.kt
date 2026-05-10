package com.example.personalbudgetmanagerapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "budgets")
data class Budget(

    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    val totalBudget: Double,

    val month: String
)