package school.lesson12.task1;

import java.util.ArrayList;
import java.util.List;

public class TriangleRepository {
    private static final List<Triangle> triangleList = new ArrayList<>();
    static {
        triangleList.add(0, new Triangle(5, 6, 9));
        triangleList.add(1, new Triangle(6, 7, 10));
        triangleList.add(2, new Triangle(3, 3, 4));
    }

    public static List<Triangle> getTriangleList() {
        return triangleList;
    }
}
