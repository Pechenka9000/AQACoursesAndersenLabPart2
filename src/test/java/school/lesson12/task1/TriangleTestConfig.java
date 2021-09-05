package school.lesson12.task1;

import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class TriangleTestConfig {
    protected  List<Double> triangleSquares = new ArrayList<>();
    {
        triangleSquares.add(12.786476987426987);
        triangleSquares.add(18.72047325122951);
        triangleSquares.add(3.968626966596886);
    }


    @BeforeEach
    public void setUp() {

        }
    }
