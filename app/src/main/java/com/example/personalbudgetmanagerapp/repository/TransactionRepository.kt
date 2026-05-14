package com.example.personalbudgetmanagerapp.repository

import com.example.personalbudgetmanagerapp.data.local.TransactionDao
import com.example.personalbudgetmanagerapp.model.Transaction
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    private val transactionDao: TransactionDao
) {

    fun getAllTransactions(): Flow<List<Transaction>> {
        return transactionDao.getAllTransactions()
    }

    fun getTransactionsForMonth(month: String): Flow<List<Transaction>> {
        return transactionDao.getTransactionsForMonth(month)
    }

    suspend fun saveTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction)
    }

    suspend fun deleteTransaction(transaction: Transaction) {
        transactionDao.deleteTransaction(transaction)
    }
}