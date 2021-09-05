package school.lesson12.task1;

public class Triangle {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double sideA, double sideB, double sideC) {
        this.a = sideA;
        this.b = sideB;
        this.c = sideC;
    }

    public double computeSquare(Triangle triangle) {
        double semiPerimeter = (a + b + c)/2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }

    @Override
    public String toString() {
        return "Треугольник со сторонами: " +
                "a = " + a + ", b = " + b +
                ", c = " + c + "; \n" +
                "площадь = " + computeSquare(this) + "; \n";
    }
}
