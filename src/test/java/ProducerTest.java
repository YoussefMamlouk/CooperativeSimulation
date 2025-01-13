import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simulation.Producer;

import static org.junit.jupiter.api.Assertions.*;

class ProducerTest {
    private Producer producer;

    @BeforeEach
    void setUp() {
        producer = new Producer("TestProducer", 3, 10, 30);
    }

    @Test
    void testGetName() {
        assertEquals("TestProducer", producer.getName());
    }

    @Test
    void testGetDeliveryForToday() {
        int deliveries = 0;
        int totalDeliverySize = 0;
        int iterations = 1000;

        for (int i = 0; i < iterations; i++) {
            int delivery = producer.getDeliveryForToday();
            if (delivery > 0) {
                deliveries++;
                totalDeliverySize += delivery;
                assertTrue(delivery >= 10 && delivery <= 30);
            }
        }

        // Check if the number of deliveries is roughly correct (allowing for some randomness)
        double expectedDeliveriesPerDay = 3.0 / 7.0;
        double actualDeliveriesPerDay = (double) deliveries / iterations;
        assertTrue(Math.abs(expectedDeliveriesPerDay - actualDeliveriesPerDay) < 0.05);

        // Check if the average delivery size is within the expected range
        double avgDeliverySize = (double) totalDeliverySize / deliveries;
        assertTrue(avgDeliverySize >= 10 && avgDeliverySize <= 30);
    }
}

