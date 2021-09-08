package school.lesson12.task1;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static double computePerimeter(Triangle triangle) {
        return (triangle.a + triangle.b + triangle.c);
    }

    public static double computeSquare(Triangle triangle) {
        double semiPerimeter = computePerimeter(triangle)/2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - triangle.a) * (semiPerimeter - triangle.b) * (semiPerimeter - triangle.c));
    }

    public static boolean isTriangle(Triangle triangle) {
        return ((triangle.a + triangle.b) > triangle.c) & ((triangle.b + triangle.c) > triangle.a) & ((triangle.a + triangle.c)) > triangle.b;
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
