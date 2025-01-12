package src.main.java;

public class Warehouse {
    private final int capacity;
    private int currentStock;
    
    public Warehouse(int capacity) {
        this.capacity = capacity;
        this.currentStock = 0;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public int getCurrentStock() {
        return currentStock;
    }
    
    public int store(int amount) {
        int availableSpace = capacity - currentStock;
        int stored = Math.min(amount, availableSpace);
        currentStock += stored;
        return stored;
    }
    
    public int retrieve(int amount) {
        int retrieved = Math.min(amount, currentStock);
        currentStock -= retrieved;
        return retrieved;
    }
}