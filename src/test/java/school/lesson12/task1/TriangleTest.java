package school.lesson12.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestResultLoggerExtension.class)
class TriangleTest extends TriangleTestConfig{

    @Test
    @DisplayName("Triangle assertPerimeter test")
    void computePerimeterTest() {
        for(int i = 0; i < expectedTrianglePerimeters.size(); i++) {
            LOGGER.info("Соответствие периметров:\nexpected - " + expectedTrianglePerimeters.get(i) +
                    "\nactual - " + Triangle.computePerimeter(TriangleRepository.getTriangleList().get(i)));
            Assertions.assertEquals(expectedTrianglePerimeters.get(i), Triangle.computePerimeter(TriangleRepository.getTriangleList().get(i)));
        }
    }

    @Test
    @DisplayName("Triangle assertSquare test")
    void computeSquareTest() {
        for(int i = 0; i < expectedTriangleSquares.size(); i++) {
            LOGGER.info("Соответствие площадей:\nexpected - " + expectedTriangleSquares.get(i) +
                    "\nactual - " + Triangle.computeSquare(TriangleRepository.getTriangleList().get(i)));
            Assertions.assertEquals(expectedTriangleSquares.get(i), Triangle.computeSquare(TriangleRepository.getTriangleList().get(i)));
        }
    }

    @Test
    @DisplayName("Triangle reality")
    void isTriangleTest() {
        TriangleRepository.getTriangleList().forEach(triangle -> {
            LOGGER.info("Проверка треугольника на существование:\nexpected - true\nactual - " + Triangle.isTriangle(triangle));
            Assertions.assertTrue(Triangle.isTriangle(triangle));
        });
        LOGGER.info("Проверка треугольника на существование:\nexpected - false\nactual - " + Triangle.isTriangle(wrongTriangle));
        Assertions.assertFalse(Triangle.isTriangle(wrongTriangle));
    }
}
