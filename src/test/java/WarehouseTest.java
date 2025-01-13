import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simulation.Warehouse;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {
    private Warehouse warehouse;

    @BeforeEach
    void setUp() {
        warehouse = new Warehouse(100);
    }

    @Test
    void testGetCapacity() {
        assertEquals(100, warehouse.getCapacity());
    }

    @Test
    void testStore() {
        assertEquals(50, warehouse.store(50));
        assertEquals(50, warehouse.getCurrentStock());

        assertEquals(50, warehouse.store(60));
        assertEquals(100, warehouse.getCurrentStock());

        assertEquals(0, warehouse.store(10));
        assertEquals(100, warehouse.getCurrentStock());
    }

    @Test
    void testRetrieve() {
        warehouse.store(80);

        assertEquals(50, warehouse.retrieve(50));
        assertEquals(30, warehouse.getCurrentStock());

        assertEquals(30, warehouse.retrieve(40));
        assertEquals(0, warehouse.getCurrentStock());

        assertEquals(0, warehouse.retrieve(10));
        assertEquals(0, warehouse.getCurrentStock());
    }
}
