package com.example.personalbudgetmanagerapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.personalbudgetmanagerapp.model.Transaction
import com.example.personalbudgetmanagerapp.model.TransactionType
import com.example.personalbudgetmanagerapp.ui.components.BudgetProgressCard
import com.example.personalbudgetmanagerapp.ui.components.SummaryCard
import com.example.personalbudgetmanagerapp.ui.components.TransactionCard
import java.util.UUID

@Composable
fun DashboardScreen() {

    val recentTransactions = listOf(
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
            amount = 3200.00,
            category = "Income",
            date = "May 8, 2026",
            type = TransactionType.INCOME
        ),
        Transaction(
            id = UUID.randomUUID(),
            title = "Netflix",
            amount = 15.99,
            category = "Entertainment",
            date = "May 7, 2026",
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

            Column {

                Text(
                    text = "Dashboard",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Track your finances easily",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        item {

            Card(
                shape = MaterialTheme.shapes.extraLarge,
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),

                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column {

                        Text(
                            text = "Current Balance",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = "1750.00$",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Surface(
                        shape = MaterialTheme.shapes.large,
                        color = MaterialTheme.colorScheme.primary
                    ) {

                        Icon(
                            imageVector = Icons.Default.AttachMoney,
                            contentDescription = "Balance",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }
        }

        item {

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                SummaryCard(
                    title = "Income",
                    amount = 3200.0,
                    icon = Icons.Default.ArrowDownward,
                    modifier = Modifier.weight(1f)
                )

                SummaryCard(
                    title = "Expenses",
                    amount = 1450.0,
                    icon = Icons.Default.ArrowUpward,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        item {

            BudgetProgressCard(
                spent = 1450.0,
                budget = 2000.0
            )
        }

        item {

            Text(
                text = "Recent Transactions",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )
        }

        items(recentTransactions) { transaction ->

            TransactionCard(
                transaction = transaction
            )
        }
    }
}