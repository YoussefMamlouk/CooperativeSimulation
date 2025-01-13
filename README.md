# Agricultural Cooperative Simulation

## Overview

This project simulates the functioning of an agricultural cooperative where multiple producers deliver their goods to a common warehouse. The simulation models various aspects of the cooperative's operations, including deliveries, warehouse capacity, and logistics involving trucks that transport goods to hypermarkets across Europe.

## Objectives

The main objectives of this simulation are:
- To model a cooperative system where producers deliver goods to a limited-capacity warehouse.
- To simulate the delivery operations of trucks transporting goods to various destinations.
- To analyze the system's performance over a specified duration with varying parameters.

## Features

- **Producers**: Multiple producers with different delivery frequencies and sizes.
- **Warehouse**: A shared storage facility with a defined capacity.
- **Trucks**: Several trucks operating 24/7 to load goods from the warehouse and deliver them to hypermarkets.
- **Simulation Duration**: The system can be simulated over several months, allowing for analysis of different scenarios.

## Parameters

The simulation allows users to adjust several parameters:
- Number of producers
- Warehouse size
- Minimum and maximum truck capacities
- Number of trucks

## Code Structure

The project consists of several classes:

| Class        | Description                                                |
|--------------|------------------------------------------------------------|
| `Main`       | Entry point for the simulation, initializes producers, warehouse, trucks, and hypermarkets. |
| `Simulation` | Manages the day-to-day operations of the cooperative and logs events. |
| `Producer`   | Represents a producer with delivery frequency and size constraints. |
| `Truck`      | Represents a truck that transports goods to hypermarkets.  |
| `Warehouse`  | Manages storage capacity and current stock levels.        |
| `Hypermarket`| Represents a destination for deliveries with associated travel time. |

## Usage

Upon running the simulation, it will log delivery activities and truck dispatches day by day for three months. Users can observe how producers deliver goods, how trucks are loaded, and how deliveries are made to hypermarkets.
