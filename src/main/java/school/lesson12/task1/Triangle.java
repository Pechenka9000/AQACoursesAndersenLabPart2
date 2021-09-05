package school.lesson12.task1;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    private static double a;
    private static double b;
    private static double c;

    public Triangle(double sideA, double sideB, double sideC) {
        a = sideA;
        b = sideB;
        c = sideC;
    }

    public static double computePerimeter(Triangle triangle) {
        return (a + b + c);
    }

    public static double computeSquare(Triangle triangle) {
        double semiPerimeter = computePerimeter(triangle)/2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }

    public static boolean isTriangle(Triangle triangle) {
        return ((a + b) > c) & ((b + c) > a) & ((a + c)) > b;
    }

    public static List<Double> squareListCreator() {
        List<Double> actualSquareList = new ArrayList<>();
        for (int i = 0; i < TriangleRepository.getTriangleList().size(); i++) {
            actualSquareList.add(Triangle.computeSquare(TriangleRepository.getTriangleList().get(i)));
        } return actualSquareList;
    }

    @Override
    public String toString() {
        return "Треугольник со сторонами: " +
                "a = " + a + ", b = " + b +
                ", c = " + c + "; \n" +
                "площадь = " + computeSquare(this) + "; \n";
    }
}
