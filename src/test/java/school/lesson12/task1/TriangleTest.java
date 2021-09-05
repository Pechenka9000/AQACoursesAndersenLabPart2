package school.lesson12.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TriangleTest extends TriangleTestConfig{

    @Test
    @DisplayName("Triangle assertSquare test")
    void computeSquare() {
        Assertions.assertAll("triangleSquares",
        () -> Assertions.assertEquals(triangleSquares[0], triangle1.computeSquare(triangle1)),
        () -> Assertions.assertEquals(triangleSquares[1], triangle2.computeSquare(triangle2)),
        () -> Assertions.assertEquals(triangleSquares[2], triangle3.computeSquare(triangle3))
    );
    }
}