package com.example.personalbudgetmanagerapp.repository

import com.example.personalbudgetmanagerapp.data.local.BudgetDao
import com.example.personalbudgetmanagerapp.model.Budget
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BudgetRepository @Inject constructor(
    private val budgetDao: BudgetDao
) {

    fun getBudgetForMonth(month: String): Flow<Budget?> {
        return budgetDao.getBudgetForMonth(month)
    }

    suspend fun saveBudget(month: String, amount: Double) {
        budgetDao.deleteBudgetForMonth(month)
        budgetDao.insertBudget(
            Budget(
                month = month,
                totalBudget = amount
            )
        )
    }
}