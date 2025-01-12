package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create Producers
        List<Producer> producers = new ArrayList<>();
        producers.add(new Producer("A", 3, 10, 30));
        producers.add(new Producer("B", 4, 5, 20));
        producers.add(new Producer("C", 2, 15, 25));
        
        // Create Warehouse
        Warehouse warehouse = new Warehouse(100);
        
        // Create Trucks
        List<Truck> trucks = new ArrayList<>();
        trucks.add(new Truck("T1", 50));
        trucks.add(new Truck("T2", 40));
        
        // Create Hypermarkets (destinations)
        List<Hypermarket> hypermarkets = new ArrayList<>();
        hypermarkets.add(new Hypermarket("Hypermarket Geneva", 1));
        hypermarkets.add(new Hypermarket("Hypermarket Berlin", 3));
        hypermarkets.add(new Hypermarket("Hypermarket Paris", 2));
        
        // Set up Simulation (3 months run)
        int totalMonths = 3;
        Simulation simulation = new Simulation(producers, warehouse, trucks, hypermarkets, totalMonths);
        simulation.run();
    }
}