package simulation;

import java.util.Random;

public class Producer {
    private final String name;
    private final int deliveriesPerWeek;
    private final int minDeliverySize;
    private final int maxDeliverySize;
    private final Random random;
    
    public Producer(String name, int deliveriesPerWeek, int minDeliverySize, int maxDeliverySize) {
        this.name = name;
        this.deliveriesPerWeek = deliveriesPerWeek;
        this.minDeliverySize = minDeliverySize;
        this.maxDeliverySize = maxDeliverySize;
        this.random = new Random();
    }
    
    public String getName() {
        return name;
    }
    
    /**
     * Called once per day in the simulation to decide whether a producer delivers goods.
     */
    public int getDeliveryForToday() {
        int daysPerWeek = 7;
        double deliveriesPerDay = (double) deliveriesPerWeek / daysPerWeek;
        
        // Decide if a delivery occurs randomly based on probability
        if (random.nextDouble() < deliveriesPerDay) {
            return random.nextInt(maxDeliverySize - minDeliverySize + 1) + minDeliverySize;
        }
        
        return 0;
    }
}
