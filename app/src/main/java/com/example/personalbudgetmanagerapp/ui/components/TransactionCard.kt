package com.example.personalbudgetmanagerapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.personalbudgetmanagerapp.model.Transaction

@Composable
fun TransactionCard(
    transaction: Transaction
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {

                Text(
                    text = transaction.category,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = transaction.date,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Text(
                text = "$${"%.2f".format(transaction.amount)}",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}