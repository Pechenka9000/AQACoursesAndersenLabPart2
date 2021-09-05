package school.lesson12.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TriangleTest extends TriangleTestConfig{

    @Test
    @DisplayName("Triangle assertSquare test")
    void computeSquareTest() {

    }


    @Test
    @DisplayName("Triangle reality")
    void isTriangleTest() {
        TriangleRepository.getTriangleList().forEach(triangle -> {
            Assertions.assertTrue(triangle.isTriangle(triangle));
            System.out.println(triangle);
        });
    }
}
