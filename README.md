# Pashu Aahar 

## Smart Nutrition for Healthy Cattle

Pashu Aahar is an Android application developed using Kotlin and Jetpack Compose that helps farmers generate affordable and nutritious cattle feed recipes based on cow breed, weight, and milk yield.

The application works completely offline and supports multiple Indian languages for better accessibility and usability among farmers.

---

## Features

-  Modern UI using Jetpack Compose
-  Multilingual Support
  - English
  - Hindi
  - Marathi
-  Cow Profile Management
-  Smart Feed Recipe Generation
-  Cost Comparison (Homemade vs Market Feed)
-  Monthly Savings Estimation
-  Veterinary Knowledge Base
-  Fully Offline Functionality
-  Clean and Farmer-Friendly Interface

---

##  Tech Stack

- Kotlin
- Jetpack Compose
- Material 3
- Navigation Compose
- Android Studio

---

##  Project Structure

```bash
Pashu_Aahar/
│
├── MainActivity.kt
├── ui/
│   └── theme/
│
├── Screens
│   ├── HomeScreen
│   ├── CowProfileScreen
│   ├── ResultScreen
│   └── TipsScreen
│
└── Components
    ├── HomeIconItem
    ├── RecipeLine
    ├── CostLine
    └── ProfileInputField
```

---

##  How It Works

### 1️ Enter Cow Details

The user provides:
- Breed
- Weight
- Milk Yield

### 2️ Feed Calculation

The app calculates:
- Maize quantity
- Oil Cake quantity
- Roughage quantity

based on cattle nutrition logic.

### 3️ Cost Analysis

The app compares:
- Homemade Feed Cost
- Market Feed Cost

and estimates:
- Daily Savings
- Monthly Savings

---

##  Nutrition Logic

```kotlin
val maize = (milk * 0.45 * breedFactor + 1.2)
val oilCake = (milk * 0.25 * breedFactor + 0.6)
val roughage = (weight * 0.02)
```

---

##  Languages Supported

- English
- हिंदी (Hindi)
- मराठी (Marathi)

---

##  Screens

- Home Screen
- Cow Profile Screen
- Result Screen
- Veterinary Tips Screen

---

##  Installation

### Clone the repository

```bash
git clone https://github.com/your-username/Pashu-Aahar.git
```

### Open in Android Studio

- Sync Gradle
- Run the application on Emulator or Android Device

---

##  Future Enhancements

- AI-based feed recommendation
- More regional language support
- Farmer login system
- Cloud backup
- Disease detection integration
- IoT-based smart farming support

---

##  Developed By

**Pranjali Holla**

Engineering Student | Android Developer | AgriTech Enthusiast

---

##  Impact Goal

Empowering farmers with scientific nutrition for better livelihood.

---

##  License

This project is developed for educational and innovation purposes.
