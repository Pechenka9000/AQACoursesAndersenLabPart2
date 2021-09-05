package school.lesson12.task1;

import java.util.ArrayList;
import java.util.List;

public class TriangleRepository {
    private static List<Triangle> triangleList = new ArrayList<>();
    static {
        triangleList.add(new Triangle(4.5, 6.2, 9.0));
        triangleList.add(new Triangle(5.5, 6.9, 9.5));
        triangleList.add(new Triangle(2.5, 3.2, 4.3));
    }

    public static List<Triangle> getTriangleList() {
        return triangleList;
    }
}
