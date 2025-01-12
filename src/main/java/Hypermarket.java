package src.main.java;

public class Hypermarket {
    private final String name;
    private final int distanceInDays;
    
    public Hypermarket(String name, int distanceInDays) {
        this.name = name;
        this.distanceInDays = distanceInDays;
    }
    
    public String getName() {
        return name;
    }
    
    public int getDistanceInDays() {
        return distanceInDays;
    }
}