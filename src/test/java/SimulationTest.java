import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simulation.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    private Simulation simulation;
    private List<Producer> producers;
    private Warehouse warehouse;
    private List<Truck> trucks;
    private List<Hypermarket> hypermarkets;

    @BeforeEach
    void setUp() {
        producers = new ArrayList<>();
        producers.add(new Producer("A", 3, 10, 30));
        producers.add(new Producer("B", 4, 5, 20));

        warehouse = new Warehouse(100);

        trucks = new ArrayList<>();
        trucks.add(new Truck("T1", 50));
        trucks.add(new Truck("T2", 40));

        hypermarkets = new ArrayList<>();
        hypermarkets.add(new Hypermarket("Hypermarket Geneva", 1));
        hypermarkets.add(new Hypermarket("Hypermarket Berlin", 3));

        simulation = new Simulation(producers, warehouse, trucks, hypermarkets, 1);
    }

    @Test
    void testRun() {
        // Ensure that the simulation runs without throwing exceptions
        assertDoesNotThrow(() -> simulation.run());
    }
}
