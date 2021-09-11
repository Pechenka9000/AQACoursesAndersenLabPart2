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
        expectedTriangleSquares.add(14.142135623730951);
        expectedTriangleSquares.add(20.662465970933866);
        expectedTriangleSquares.add(4.47213595499958);
    }

    protected  List<Integer> expectedTrianglePerimeters = new ArrayList<>();
    {
        expectedTrianglePerimeters.add(20);
        expectedTrianglePerimeters.add(23);
        expectedTrianglePerimeters.add(10);
    }

    @BeforeAll
    public static void setUp() {
        LOGGER = LoggerFactory.getLogger(TriangleTestConfig.class.getName());
        // Инициализация несуществующего треугольника
        wrongTriangle = new Triangle(2, 8, 3);
        }
    }
