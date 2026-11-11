# first-aid-assistant

A Java and CLIPS-based application that provides first-aid recommendations based on user-selected injury categories and symptom responses.

## Introduction

This project aims to help people with little or no knowledge of first aid respond to medical emergencies.

Users select an injury category and answer two short Yes/No questions to help identify its severity. Based on their responses, the application determines the corresponding severity classification and provides first-aid recommendations.

The questions are designed to be direct and easy to understand, helping users identify relevant symptoms.

## Features

- 10 injury categories.
- Two symptom-related questions per category.
- Yes/No input validation.
- Three severity classifications: Mild, Severe and Ambiguous.
- Rule-based recommendation generation.

## Injury Categories

1. Bleeding
2. Burns
3. Fractures
4. Head Injury
5. Choking
6. Shock
7. Hypothermia
8. Heatstroke
9. Poisoning / Overdose
10. Seizures

## Technologies Used

- **Java:** Handles the command-line interface, user input and fact assertion.
- **CLIPS:** Manages the knowledge base and recommendation rules.
- **CLIPSJNI:** Connects the Java application with the CLIPS environment.

## Implementation

The application uses Java to collect user responses and assert corresponding facts into the CLIPS environment.

CLIPS evaluates the asserted facts against the predefined rules using forward chaining to determine the appropriate recommendations.

The knowledge base contains 20 rules covering 10 injury categories, with different severity classifications for each category.

Decision trees were used to determine injury severity based on combinations of user responses.

## Knowledge Sources

The first-aid recommendations were developed using the St John Ambulance first-aid guidebook.

## Disclaimer

This project is an academic software development project and is not a substitute for professional medical advice or emergency services.
