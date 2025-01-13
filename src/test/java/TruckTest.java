import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simulation.*;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
    private Truck truck;
    private Hypermarket hypermarket;

    @BeforeEach
    void setUp() {
        truck = new Truck("T1", 50);
        hypermarket = new Hypermarket("TestMarket", 3);
    }

    @Test
    void testGetTruckId() {
        assertEquals("T1", truck.getTruckId());
    }

    @Test
    void testGetCapacity() {
        assertEquals(50, truck.getCapacity());
    }

    @Test
    void testLoad() {
        assertEquals(30, truck.load(30));
        assertEquals(30, truck.getCargo());

        assertEquals(50, truck.load(70));
        assertEquals(50, truck.getCargo());
    }

    @Test
    void testDispatchAndAdvance() {
        assertFalse(truck.isInTransit());

        truck.load(40);
        truck.dispatch(hypermarket);

        assertTrue(truck.isInTransit());
        assertEquals(40, truck.getCargo());

        truck.advanceOneDay();
        assertTrue(truck.isInTransit());
        assertEquals(40, truck.getCargo());

        truck.advanceOneDay();
        assertTrue(truck.isInTransit());
        assertEquals(40, truck.getCargo());

        truck.advanceOneDay();
        assertFalse(truck.isInTransit());
        assertEquals(0, truck.getCargo());
    }
}
