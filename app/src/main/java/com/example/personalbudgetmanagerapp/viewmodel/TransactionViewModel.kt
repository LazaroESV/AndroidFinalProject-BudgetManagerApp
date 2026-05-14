package com.example.personalbudgetmanagerapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personalbudgetmanagerapp.model.Transaction
import com.example.personalbudgetmanagerapp.model.TransactionType
import com.example.personalbudgetmanagerapp.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID
import javax.inject.Inject

data class TransactionFormState(
    val id: UUID? = null,
    val title: String = "",
    val amount: String = "",
    val category: String = "",
    val date: String = todayDate(),
    val type: TransactionType = TransactionType.EXPENSE
)

private fun todayDate(): String {
    return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
}

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val repository: TransactionRepository
) : ViewModel() {

    private val _formState = MutableStateFlow(TransactionFormState())
    val formState: StateFlow<TransactionFormState> = _formState.asStateFlow()

    val transactions: StateFlow<List<Transaction>> =
        repository.getAllTransactions().stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            emptyList()
        )

    fun onTitleChange(value: String) {
        _formState.value = _formState.value.copy(title = value)
    }

    fun onAmountChange(value: String) {
        _formState.value = _formState.value.copy(amount = value)
    }

    fun onCategoryChange(value: String) {
        _formState.value = _formState.value.copy(category = value)
    }

    fun onDateChange(value: String) {
        _formState.value = _formState.value.copy(date = value)
    }

    fun onTypeChange(value: TransactionType) {
        _formState.value = _formState.value.copy(type = value)
    }

    fun loadTransaction(transaction: Transaction) {
        _formState.value = TransactionFormState(
            id = transaction.id,
            title = transaction.title,
            amount = transaction.amount.toString(),
            category = transaction.category,
            date = transaction.date,
            type = transaction.type
        )
    }

    fun resetForm() {
        _formState.value = TransactionFormState()
    }

    fun addTransaction(transaction: Transaction) {

        viewModelScope.launch {
            repository.saveTransaction(transaction)
        }
    }
    fun deleteTransaction(transaction: Transaction) {
        viewModelScope.launch {
            repository.deleteTransaction(transaction)
        }
    }
}