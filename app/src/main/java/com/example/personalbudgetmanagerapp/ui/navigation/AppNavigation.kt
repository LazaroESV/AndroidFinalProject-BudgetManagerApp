// app/src/main/java/com/example/personalbudgetmanagerapp/ui/navigation/AppNavigation.kt
package com.example.personalbudgetmanagerapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.personalbudgetmanagerapp.ui.components.BottomNavBar
import com.example.personalbudgetmanagerapp.ui.screen.AddTransactionScreen
import com.example.personalbudgetmanagerapp.ui.screen.BudgetScreen
import com.example.personalbudgetmanagerapp.ui.screen.CategoryScreen
import com.example.personalbudgetmanagerapp.ui.screen.DashboardScreen
import com.example.personalbudgetmanagerapp.ui.screen.TransactionHistoryScreen

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            BottomNavBar(
                navController = navController
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier.padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(
                navController = navController,
                startDestination = "dashboard"
            ) {
                composable("dashboard") {
                    DashboardScreen()
                }

                composable("history") {
                    TransactionHistoryScreen()
                }

                composable("add_transaction") {
                    AddTransactionScreen(
                        onTransactionSaved = {
                            navController.navigate("history") {
                                popUpTo("add_transaction"){
                                    inclusive = true
                                }
                            }
                        }
                    )
                }

                composable("budget") {
                    BudgetScreen()
                }

                composable("categories") {
                    CategoryScreen()
                }
            }
        }
    }
}