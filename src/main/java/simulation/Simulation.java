package simulation;

import java.util.List;
import java.util.Random;

public class Simulation {
    private final List<Producer> producers;
    private final Warehouse warehouse;
    private final List<Truck> trucks;
    private final List<Hypermarket> hypermarkets;
    private final int totalMonths;
    private final Random random;
    
    public Simulation(
            List<Producer> producers,
            Warehouse warehouse,
            List<Truck> trucks,
            List<Hypermarket> hypermarkets,
            int totalMonths) {
        
        this.producers = producers;
        this.warehouse = warehouse;
        this.trucks = trucks;
        this.hypermarkets = hypermarkets;
        this.totalMonths = totalMonths;
        
        this.random = new Random();
    }
    
    /**
     * Runs the simulation day by day.
     */
    public void run() {
        System.out.println("=== Starting Simulation for " + totalMonths + " months ===");
        System.out.println("Warehouse Capacity: " + warehouse.getCapacity());
        
        for (int month = 1; month <= totalMonths; month++) {
            System.out.println("\n=== Month " + month + " ===");
            
            for (int day = 1; day <= 30; day++) {
                System.out.println("\n--- Day " + day + " ---");
                
                // Producers deliver to warehouse
                producerDeliveries();
                
                // Load and dispatch trucks if possible
                loadAndDispatchTrucks();
                
                // Advance trucks on the road
                advanceTrucks();
            }
        }
        
        System.out.println("=== Simulation Complete ===");
    }
    
    /**
     * Each producer may deliver goods today.
     * We store what we can in the warehouse (limited by capacity).
     */
    private void producerDeliveries() {
        for (Producer p : producers) {
            int deliveryAmount = p.getDeliveryForToday();
            if (deliveryAmount > 0) {
                int stored = warehouse.store(deliveryAmount);
                
                System.out.println("[Producer " + p.getName() + "] delivered " + deliveryAmount 
                        + " units. Stored " + stored + " units in warehouse. Current Stock: "
                        + warehouse.getCurrentStock());
                
                if (stored < deliveryAmount) {
                    System.out.println(">> Warehouse was full! " 
                            + (deliveryAmount - stored) + " units not stored.");
                }
            }
        }
    }
    
    /**
     * Each available truck is loaded (if there is enough stock), then dispatched to a random hypermarket.
     */
    private void loadAndDispatchTrucks() {
        for (Truck truck : trucks) {
            if (!truck.isInTransit()) {
                // Try to load from warehouse
                int retrieved = warehouse.retrieve(truck.getCapacity());
                if (retrieved > 0) {
                    truck.load(retrieved);
                    // pick a random hypermarket
                    Hypermarket destination = hypermarkets.get(random.nextInt(hypermarkets.size()));
                    truck.dispatch(destination);
                    
                    System.out.println("[Truck " + truck.getTruckId() + "] loaded " + retrieved 
                            + " units and departed for " + destination.getName());
                }
            }
        }
    }
    
    /**
     * Advance the day for each truck. If a truck arrives, it logs a delivery event.
     */
    private void advanceTrucks() {
        for (Truck truck : trucks) {
            truck.advanceOneDay();
        }
    }
}
