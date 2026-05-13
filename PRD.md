# PROJECT REQUIREMENTS DOCUMENT (PRD)

## Project Details
- **Project Title**: Pashu-Aahar – Cattle Nutrition Calculator
- **Project Code**: 19 – Android App Development using GenAI
- **Internship Program**: MindMatrix VTU Internship Program
- **Platform**: Android
- **Language**: Kotlin
- **Document Status**: Final Implementation Draft
- **Date**: April 2026

---

## 1. Introduction
Pashu-Aahar is an Android-based mobile application designed to help farmers create balanced cattle feed using locally available ingredients. The application provides feed recommendations based on cow profile and milk yield, helping farmers reduce costs and improve productivity.

## 2. Problem Statement
Small farmers often purchase expensive branded cattle feed without knowing how to prepare balanced nutrition at home using locally available grains. This leads to increased costs and reduced profitability. There is a need for a simple tool that helps farmers generate optimal feed recipes.

## 3. Objectives
- **01 Feed Recommendation System**: Provide a feed recommendation system based on cow profile.
- **02 Balanced Feed Recipes**: Generate balanced feed recipes using local ingredients.
- **03 Cost Comparison**: Compare cost between homemade and market feed.
- **04 Improved Productivity**: Improve milk yield and reduce feeding costs.
- **05 Scientific Farming**: Promote scientific and affordable farming practices.

## 4. Product Vision & Description
The Pashu-Aahar application acts as a "Cattle Nutrition Calculator." Farmers enter details such as breed, age, weight, and milk yield. The app generates a balanced feed recipe using locally available ingredients and provides cost comparison insights. It simplifies decision-making for farmers and promotes efficient feeding practices.

## 5. Scope of Project
### In Scope
- Cow profile input (breed, age, weight, milk yield)
- Feed recipe generation (Maize, Oil Cake, Roughage)
- Cost comparison (homemade vs market feed)
- Multi-language support (English, Hindi, Marathi)
- Veterinary Knowledge Base (Hygiene, Storage, Watering)
- Offline functionality
- Simple, farmer-friendly UI

### Out of Scope
- Real-time market price updates
- Veterinary consultation system
- IoT-based cattle monitoring
- Online ordering of feed
- Backend server integration

## 6. Target Users & Features
### Target Users
- Small-scale farmers
- Dairy farmers
- Rural livestock owners
- Agricultural workers

### Key Features
- **Cow Profile Input**: Users enter cow details such as breed, age, weight, and milk yield.
- **Feed Recipe Generator**: Generates a balanced feed mix using ingredients like maize, oil cake, etc.
- **Cost Comparison**: Compares homemade feed cost with market feed cost.
- **Cost Savings Visualization**: Displays monthly and daily savings.
- **Veterinary Knowledge Base**: Provides tips on cattle care and hygiene.
- **Multi-lingual**: Toggle between English, Hindi, and Marathi.

## 7. Functional Requirements
1. The system shall allow users to input cow details.
2. The system shall generate feed recipes based on input data.
3. The system shall calculate feed proportions using nutrition logic.
4. The system shall compare homemade vs market feed costs.
5. The system shall display cost savings.
6. The system shall store predefined feed ingredient data.
7. The system shall allow navigation between screens.
8. The system shall work offline.

## 8. Non-Functional Requirements
- **Performance**: The system shall provide fast response time.
- **Usability**: The UI shall be simple and understandable for farmers.
- **Reliability**: The application shall not crash during usage.
- **Offline Capability**: The system shall work offline without internet.
- **Efficiency**: The application shall consume minimal device resources.
- **Visual Design**: The UI shall be visually clear with icons and simple layout.

## 9. Data Requirements
The application uses a predefined dataset of feed ingredients with nutritional values and cost data.

## 10. Technical Requirements
- **Platform**: Android
- **Language**: Kotlin (Jetpack Compose)
- **Data Storage**: Local data (Static maps/JSON)
- **IDE**: Android Studio

## 11. User Flow
1. **Open App**: Language selection if needed.
2. **Enter Cow Details**: Breed, weight, milk yield.
3. **Generate Feed Recipe**: Instant calculation.
4. **View Cost Comparison**: Check daily and monthly savings.
5. **Knowledge Base**: Read veterinary tips.

## 12. Success Criteria
- Feed recipe generated correctly.
- Cost comparison is accurate.
- App works 100% offline.
- UI is simple and easy to navigate.
- Multi-language switching works seamlessly.

## 13. Future Enhancements
- Real-time feed price updates.
- AI-based recommendations.
- Integration with veterinary services.

## 14. Conclusion
The Pashu-Aahar application provides a practical solution to reduce cattle feeding costs and improve milk production. It empowers farmers with scientific feeding knowledge in a simple and accessible format.
