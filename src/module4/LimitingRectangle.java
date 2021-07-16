package module4;

public class LimitingRectangle {

    int[][] points;

    public LimitingRectangle(int[][] arr) {
        points = arr;
    }

    public int getWidth() {
        if (points[0][0] < 0) return Math.abs(points[0][0]) + points[1][0];
        return points[1][0] - points[0][0];
    }

    public int getHeight() {
        if (points[0][1] < 0) return Math.abs(points[0][1]) + points[1][1];
        return points[1][1] - points[0][1];
    }

    public String getBorders() {
        return String.format("%d, %d, %d, %d", points[0][1], points[1][1], points[0][0], points[1][0]);
    }
}
