package school.lesson12.task1;

import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Step("Расчет периметра треугольника")
    public static int computePerimeter(Triangle triangle) {
        return (triangle.a + triangle.b + triangle.c);
    }

    @Step("Расчет площади треугольника")
    public static double computeSquare(Triangle triangle) {
        double semiPerimeter = computePerimeter(triangle)/2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - triangle.a) * (semiPerimeter - triangle.b) * (semiPerimeter - triangle.c));
    }

    @Step("Проверка треугольника на 'существование'")
    public static boolean isTriangle(Triangle triangle) {
        return ((triangle.a + triangle.b) > triangle.c) & ((triangle.b + triangle.c) > triangle.a) & ((triangle.a + triangle.c)) > triangle.b;
    }

    @Step("Создание списка вычисленных площадей треугольников")
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
