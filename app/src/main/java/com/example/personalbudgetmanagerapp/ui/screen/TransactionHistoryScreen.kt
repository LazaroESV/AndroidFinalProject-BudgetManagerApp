package com.example.personalbudgetmanagerapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.personalbudgetmanagerapp.model.Transaction
import com.example.personalbudgetmanagerapp.model.TransactionType
import com.example.personalbudgetmanagerapp.ui.components.TransactionCard

@Composable
fun TransactionHistoryScreen() {

    val transactions = listOf(

        // Adding dummy data
        Transaction(
            title = "Groceries",
            amount = 85.50,
            category = "Food",
            date = "2026-05-10",
            type = TransactionType.EXPENSE
        ),

        Transaction(
            title = "Salary",
            amount = 2500.0,
            category = "Work",
            date = "2026-05-08",
            type = TransactionType.INCOME
        )
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "Transaction History",
            style = MaterialTheme.typography.headlineMedium
        )

        LazyColumn {

            items(transactions) { transaction ->

                TransactionCard(
                    transaction = transaction
                )
            }
        }
    }
}