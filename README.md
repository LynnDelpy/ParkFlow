# Parking Garage Simulation

## Overview

This project simulates a parking garage system with basic functionalities including car parking, payment processing, and car exiting. It features an interaction between various components such as `ParkingGarage`, `ParkingSpot`, `Ticket`, `PaymentMachine`, `UserInterface`, and a `Controller` that manages the workflow.

## Features

- **Parking Cars**: Assigns a parking spot to a car and issues a ticket.
- **Payment Processing**: Allows users to pay for their parking ticket, handles payment logic, and ensures that payments are processed correctly.
- **Car Exiting**: Handles the process of car exiting, including spot freeing and ticket validation.
- **User Interface**: Provides methods to interact with the user, including displaying messages and processing user inputs.
- **Display**: Updates the number of available parking spots.

## Components

- **Main**: Entry point of the application that initializes the system and starts the `Controller`.
- **Controller**: Manages the interaction between `ParkingGarage`, `UserInterface`, `PaymentMachine`, and other components.
- **ParkingGarage**: Manages parking spots, ticket creation, and car exiting.
- **ParkingSpot**: Represents individual parking spots in the garage.
- **Ticket**: Represents parking tickets with payment status and fee calculation.
- **PaymentMachine**: Handles payment processing through the `Payment` class.
- **UserInterface**: Provides methods for user interaction, such as displaying messages and processing payments.
- **Display**: Shows the current number of available parking spots.

## Usage

1. **Run the Application**: Start the simulation by running the `Main` class.
2. **Parking Process**: Follow the prompts to park a car and receive a ticket.
3. **Payment**: Enter the amount to pay when prompted. The system will process the payment.
4. **Exit**: After payment, follow the instructions to exit the parking garage.
