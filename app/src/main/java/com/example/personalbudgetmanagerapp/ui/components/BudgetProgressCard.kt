package com.example.personalbudgetmanagerapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BudgetProgressCard(
    spentAmount: Double,
    totalBudget: Double
) {

    val progress =
        if (totalBudget > 0)
            (spentAmount / totalBudget).toFloat()
        else
            0f

    val remaining = totalBudget - spentAmount

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text(
                text = "Monthly Budget",
                style = MaterialTheme.typography.titleMedium
            )

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Spent: $${"%.2f".format(spentAmount)}"
            )

            Text(
                text = "Remaining: $${"%.2f".format(remaining)}"
            )
        }
    }
}