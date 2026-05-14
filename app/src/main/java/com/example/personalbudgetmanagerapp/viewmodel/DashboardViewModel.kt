package com.example.personalbudgetmanagerapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personalbudgetmanagerapp.model.Transaction
import com.example.personalbudgetmanagerapp.model.TransactionType
import com.example.personalbudgetmanagerapp.repository.BudgetRepository
import com.example.personalbudgetmanagerapp.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

data class DashboardUiState(
    val totalIncome: Double = 0.0,
    val totalExpenses: Double = 0.0,
    val balance: Double = 0.0,
    val monthlyBudget: Double = 0.0,
    val remainingBudget: Double = 0.0,
    val recentTransactions: List<Transaction> = emptyList(),
    val categoryTotals: Map<String, Double> = emptyMap()
)

private fun currentMonth(): String {
    return SimpleDateFormat("yyyy-MM", Locale.getDefault()).format(Date())
}

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository,
    private val budgetRepository: BudgetRepository
) : ViewModel() {

    private val month = currentMonth()

    val uiState: StateFlow<DashboardUiState> =
        combine(
            transactionRepository.getTransactionsForMonth(month),
            budgetRepository.getBudgetForMonth(month)
        ) { transactions, budget ->

            val income = transactions
                .filter { it.type == TransactionType.INCOME }
                .sumOf { it.amount }

            val expenses = transactions
                .filter { it.type == TransactionType.EXPENSE }
                .sumOf { it.amount }

            val budgetAmount = budget?.totalBudget ?: 0.0
            val remaining = budgetAmount - expenses

            val categoryTotals = transactions
                .filter { it.type == TransactionType.EXPENSE }
                .groupBy { it.category }
                .mapValues { entry -> entry.value.sumOf { it.amount } }

            DashboardUiState(
                totalIncome = income,
                totalExpenses = expenses,
                balance = income - expenses,
                monthlyBudget = budgetAmount,
                remainingBudget = remaining,
                recentTransactions = transactions.take(5),
                categoryTotals = categoryTotals
            )
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            DashboardUiState()
        )

    fun saveBudget(amount: Double) {
        viewModelScope.launch {
            budgetRepository.saveBudget(month, amount)
        }
    }
}