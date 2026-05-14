package com.example.personalbudgetmanagerapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.personalbudgetmanagerapp.model.Transaction
import com.example.personalbudgetmanagerapp.model.TransactionType
import com.example.personalbudgetmanagerapp.viewmodel.TransactionViewModel
import kotlinx.coroutines.launch

@Composable
fun AddTransactionScreen(
    onTransactionSaved: () -> Unit = {},
    viewModel: TransactionViewModel = hiltViewModel()
) {

    val formState by viewModel.formState.collectAsState()
    val scope = rememberCoroutineScope()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "Add Transaction",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "Track your income and expenses by entering transaction details below.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    OutlinedTextField(
                        value = formState.title,
                        onValueChange = { viewModel.onTitleChange(it) },
                        label = { Text("Title") },
                        placeholder = { Text("Example: Grocery Shopping") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = formState.amount,
                        onValueChange = { viewModel.onAmountChange(it) },
                        label = { Text("Amount") },
                        placeholder = { Text("Enter amount") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = formState.category,
                        onValueChange = { viewModel.onCategoryChange(it) },
                        label = { Text("Category") },
                        placeholder = { Text("Food, Bills, Transport...") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = formState.date,
                        onValueChange = { viewModel.onDateChange(it) },
                        label = { Text("Date") },
                        placeholder = { Text("YYYY-MM-DD") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                            onClick = {

                                val amountValue =
                                    formState.amount
                                        .replace(',', '.')
                                        .toDoubleOrNull()

                                if (
                                    formState.title.isNotBlank() &&
                                    formState.category.isNotBlank() &&
                                    formState.date.isNotBlank() &&
                                    amountValue != null
                                ) {

                                    scope.launch {
                                        viewModel.addTransaction(
                                            Transaction(
                                                title = formState.title,
                                                amount = amountValue,
                                                category = formState.category,
                                                date = formState.date,
                                                type = TransactionType.EXPENSE
                                            )
                                        )

                                        onTransactionSaved()
                                    }
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text("Save (Expense)")
                    }
                    Button(
                        onClick = {

                            val amountValue =
                                formState.amount
                                    .replace(',', '.')
                                    .toDoubleOrNull()

                            if (
                                formState.title.isNotBlank() &&
                                formState.category.isNotBlank() &&
                                formState.date.isNotBlank() &&
                                amountValue != null
                            ) {

                                scope.launch {
                                    viewModel.addTransaction(
                                        Transaction(
                                            title = formState.title,
                                            amount = amountValue,
                                            category = formState.category,
                                            date = formState.date,
                                            type = TransactionType.INCOME
                                        )
                                    )

                                    onTransactionSaved()
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text("Save (Income)")
                    }
                }
            }
        }
    }
}