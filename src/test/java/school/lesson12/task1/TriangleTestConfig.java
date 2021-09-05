package school.lesson12.task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

public class TriangleTestConfig {
    protected Triangle triangle1;
    protected Triangle triangle2;
    protected Triangle triangle3;
    protected String s = "Треугольник со сторонами: a = 4.5, b = 6.2, c = 9.0; \nплощадь = 12.786476987426987";
    static List<Triangle> triangleList = new ArrayList<>();
    static {
        triangleList.add(new Triangle(4.5, 6.2, 9.0));
        triangleList.add(new Triangle(5.5, 6.9, 9.5));
        triangleList.add(new Triangle(2.5, 3.2, 4.3));

    }
    protected double[] triangleSquares = {12.786476987426987,
                                        18.72047325122951,
                                        3.968626966596886};

    @BeforeClass
    public static void setupClass() {
    }

    @BeforeEach
    void setUp() {
        System.out.println(s);
        triangle1 = new Triangle(4.5, 6.2, 9.0);
        triangle2 = new Triangle(5.5, 6.9, 9.5);
        triangle3 = new Triangle(2.5, 3.2, 4.3);
        for(int i = 0; i < triangleList.size(); i++) {
            triangleList.get(i);
        }
    }
}
