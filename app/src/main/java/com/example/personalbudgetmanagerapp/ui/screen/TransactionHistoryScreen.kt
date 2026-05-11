package com.example.personalbudgetmanagerapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.personalbudgetmanagerapp.model.Transaction
import com.example.personalbudgetmanagerapp.model.TransactionType
import com.example.personalbudgetmanagerapp.ui.components.TransactionCard
import java.util.UUID

@Composable
fun TransactionHistoryScreen() {

    val transactions = listOf(

        // Insert dummy data
        Transaction(
            id = UUID.randomUUID(),
            title = "Groceries",
            amount = 85.50,
            category = "Food",
            date = "May 10, 2026",
            type = TransactionType.EXPENSE
        ),

        Transaction(
            id = UUID.randomUUID(),
            title = "Salary",
            amount = 2500.0,
            category = "Work",
            date = "May 8, 2026",
            type = TransactionType.INCOME
        ),

        Transaction(
            id = UUID.randomUUID(),
            title = "Netflix",
            amount = 15.99,
            category = "Entertainment",
            date = "May 6, 2026",
            type = TransactionType.EXPENSE
        ),

        Transaction(
            id = UUID.randomUUID(),
            title = "Bus Pass",
            amount = 45.00,
            category = "Transport",
            date = "May 5, 2026",
            type = TransactionType.EXPENSE
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp),

        contentPadding = PaddingValues(
            top = 24.dp,
            bottom = 100.dp
        )
    ) {

        item {

            Text(
                text = "Transaction History",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }

        item {

            Text(
                text = "Review all your recent financial activity",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        item {

            Card(
                shape = MaterialTheme.shapes.extraLarge,
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {

                androidx.compose.foundation.layout.Row(
                    modifier = Modifier.padding(20.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Surface(
                        shape = MaterialTheme.shapes.large,
                        color = MaterialTheme.colorScheme.primary
                    ) {

                        Icon(
                            imageVector = Icons.Default.History,
                            contentDescription = "History",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.padding(12.dp)
                        )
                    }

                    androidx.compose.foundation.layout.Column {

                        Text(
                            text = "${transactions.size} Transactions",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Income and expense records",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }

        items(transactions) { transaction ->

            TransactionCard(
                transaction = transaction
            )
        }
    }
}