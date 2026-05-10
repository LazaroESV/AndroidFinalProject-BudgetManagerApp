package com.example.personalbudgetmanager.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

data class BottomNavItem(
    val label: String,
    val route: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

@Composable
fun BottomNavBar(
    navController: NavController,
    currentRoute: String?
) {

    val items = listOf(
        BottomNavItem(
            label = "Dashboard",
            route = "dashboard",
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            label = "Transactions",
            route = "transactions",
            icon = Icons.Default.History
        ),
        BottomNavItem(
            label = "Add",
            route = "add_transaction",
            icon = Icons.Default.Add
        ),
        BottomNavItem(
            label = "Budget",
            route = "budget",
            icon = Icons.Default.AccountBalanceWallet
        )
    )

    NavigationBar {

        items.forEach { item ->

            NavigationBarItem(
                selected = currentRoute == item.route,

                onClick = {
                    navController.navigate(item.route)
                },

                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                },

                label = {
                    Text(text = item.label)
                }
            )
        }
    }
}