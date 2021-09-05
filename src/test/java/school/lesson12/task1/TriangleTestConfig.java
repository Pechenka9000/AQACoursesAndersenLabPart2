package school.lesson12.task1;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TriangleTestConfig {
    protected static Logger LOGGER;
    // Объявление несуществующего треугольника
    protected static Triangle wrongTriangle;
    protected  List<Double> expectedTriangleSquares = new ArrayList<>();
    {
        expectedTriangleSquares.add(12.786476987426987);
        expectedTriangleSquares.add(18.72047325122951);
        expectedTriangleSquares.add(3.968626966596886);
    }

    protected  List<Double> expectedTrianglePerimeters = new ArrayList<>();
    {
        expectedTrianglePerimeters.add(19.7);
        expectedTrianglePerimeters.add(21.9);
        expectedTrianglePerimeters.add(10.0);
    }

    @BeforeAll
    public static void setUp() {
        LOGGER = LoggerFactory.getLogger(TriangleTestConfig.class.getName());
        // Инициализация несуществующего треугольника
        wrongTriangle = new Triangle(2.1, 8.0, 3.2);
        }
    }
