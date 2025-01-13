import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simulation.Hypermarket;

import static org.junit.jupiter.api.Assertions.*;

class HypermarketTest {
    private Hypermarket hypermarket;

    @BeforeEach
    void setUp() {
        hypermarket = new Hypermarket("TestMarket", 3);
    }

    @Test
    void testGetName() {
        assertEquals("TestMarket", hypermarket.getName());
    }

    @Test
    void testGetDistanceInDays() {
        assertEquals(3, hypermarket.getDistanceInDays());
    }
}
