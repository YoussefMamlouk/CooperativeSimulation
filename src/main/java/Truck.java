package src.main.java;

public class Truck {
    private final String truckId;
    private final int capacity;
    
    private boolean inTransit;
    private int daysUntilArrival;
    private Hypermarket destination;
    private int cargo;
    
    public Truck(String truckId, int capacity) {
        this.truckId = truckId;
        this.capacity = capacity;
        this.inTransit = false;
        this.daysUntilArrival = 0;
        this.destination = null;
        this.cargo = 0;
    }
    
    public String getTruckId() {
        return truckId;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public boolean isInTransit() {
        return inTransit;
    }
    
    public int getCargo() {
        return cargo;
    }
    
    public int load(int amount) {
        int loadable = Math.min(amount, capacity);
        cargo = loadable;
        return loadable;
    }
    
    public void dispatch(Hypermarket hypermarket) {
        this.destination = hypermarket;
        this.daysUntilArrival = hypermarket.getDistanceInDays();
        this.inTransit = true;
    }
    
    /**
     * Advance one simulation day. If the truck is in transit, decrease daysUntilArrival.
     * If it arrives, unload it (cargo = 0) and set inTransit to false.
     */
    public void advanceOneDay() {
        if (inTransit) {
            daysUntilArrival--;
            if (daysUntilArrival <= 0) {
                // The truck has arrived at the hypermarket
                System.out.println("[Truck " + truckId + "] Arrived at " + destination.getName() 
                    + " and delivered " + cargo + " units of goods.");
                cargo = 0;
                inTransit = false;
            }
        }
    }
}