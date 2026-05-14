# Personal Budget Manager App

## Overview
Personal Budget Manager App is an Android application built with Kotlin and Jetpack Compose that helps users track their income, expenses, and monthly budgets.

The application provides a clean Material 3 interface for managing transactions, monitoring spending progress, and viewing financial summaries.

---

# Features

## Dashboard
- Displays current balance
- Shows income and expense summaries
- Budget progress tracking
- Recent transaction overview

## Transaction Management
- Add income and expense transactions
- Categorize transactions
- View transaction history

## Budget Tracking
- Set monthly budgets
- Monitor spending progress
- View remaining budget amount

## Categories
- Organized expense categories
- Visual category overview

---

# Technologies Used

- Kotlin
- Jetpack Compose
- Material 3
- Room Database
- MVVM Architecture
- Hilt Dependency Injection
- Navigation Compose
- Kotlin Coroutines
- KSP (Kotlin Symbol Processing)

---

# Project Structure

```text
com.example.personalbudgetmanagerapp
│
├── data
│   ├── local
│   └── converters
│
├── model
│
├── repository
│
├── viewmodel
│
├── di
│
├── ui
│   ├── components
│   ├── navigation
│   ├── screen
│   └── theme
│
├── MainActivity.kt
└── BudgetManagerApplication.kt
```

---

# Requirements

Before running the project, make sure you have:

- Android Studio Otter or newer
- JDK 11 installed
- Android SDK installed
- Gradle installed (optional)
- Android device or emulator

---

# Setup Instructions

## 1. Clone or Download the Project

Download the project ZIP file or clone the repository.

```bash
git clone https://github.com/LazaroESV/AndroidFinalProject-BudgetManagerApp
```

---

## 2. Open the Project

1. Open Android Studio
2. Select:

```text
Open an Existing Project
```

3. Choose the project folder

---

## 3. Sync Gradle

After opening the project:

```text
File → Sync Project with Gradle Files
```

Wait for Gradle synchronization to complete.

---

## 4. Install JDK 11

If you encounter a Java toolchain error:

```text
Cannot find a Java installation matching version 11
```

Install JDK 11 and configure it in Android Studio:

```text
File → Settings → Build, Execution, Deployment → Build Tools → Gradle
```

Set:

```text
Gradle JDK = JDK 11
```

---

# Running the Application

## Using an Emulator

1. Open Android Studio
2. Start an Android Emulator
3. Click:

```text
Run ▶ app
```

---

## Using a Physical Android Device

1. Enable Developer Options on your phone
2. Enable USB Debugging
3. Connect the device to your computer
4. Click:

```text
Run ▶ app
```

# Usage Instructions

## Dashboard
View:
- Current balance
- Income summary
- Expense summary
- Budget progress
- Recent transactions

---

## Add Transaction

1. Open the Add screen
2. Enter:
   - Title
   - Amount
   - Category
   - Date
3. Save the transaction

---

## Transaction History

View all recorded transactions and financial activity.

---

## Budget Screen

1. Enter your monthly budget
2. Save the budget
3. Monitor spending progress

---

## Category Screen

Browse predefined expense categories.

---

# Architecture

The project follows the MVVM (Model-View-ViewModel) architecture:

- Model → Data layer and entities
- View → Jetpack Compose UI screens
- ViewModel → State management and business logic
- Repository → Data access abstraction

---

# Database

The application uses Room Database for local data persistence.

Entities:
- Transaction
- Budget

DAOs:
- TransactionDao
- BudgetDao

---

# Future Improvements

Possible future enhancements:

- Charts and analytics
- Dark mode customization
- Export/import functionality
- Cloud synchronization
- Authentication system
- Recurring transactions
- Notifications and reminders

---

# Author

Authors : Miguel Urribarres Alfonso & Lazaro Ernesto Sagarra Valdes 
Created as an Android development project using Kotlin and Jetpack Compose.

---

# License

This project is for educational purposes.

