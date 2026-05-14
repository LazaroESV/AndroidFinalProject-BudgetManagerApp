package com.example.personalbudgetmanagerapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.personalbudgetmanagerapp.data.local.converters.UUIDConverter
import com.example.personalbudgetmanagerapp.model.Budget
import com.example.personalbudgetmanagerapp.model.Transaction

@Database(
    entities = [Transaction::class, Budget::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(UUIDConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun budgetDao(): BudgetDao
}