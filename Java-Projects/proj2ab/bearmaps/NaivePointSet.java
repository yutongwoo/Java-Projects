package bearmaps;

import java.util.ArrayList;
import java.util.List;

public class NaivePointSet implements PointSet {
    List<Point> list;
    public NaivePointSet(List<Point> points) {
        list = new ArrayList<>();
        list.addAll(points);
    }

    @Override
    public Point nearest(double x, double y) {
        Point origin = new Point(x, y);
        Point near = list.get(0);
        double dis = Point.distance(origin, near);
        for (Point point: list) {
            double tempdis = Point.distance(origin, point);
            if (tempdis < dis) {
                near = point;
                dis = tempdis;
            }
        }
        return near;
    }

    public static void main(String[] args) {
        Point p1 = new Point(1.1, 2.2); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(3.3, 4.4);
        Point p3 = new Point(-2.9, 4.2);

        NaivePointSet nn = new NaivePointSet(List.of(p1, p2, p3));
        Point ret = nn.nearest(3.0, 4.0); // returns p2
        ret.getX(); // evaluates to 3.3
        ret.getY(); // evaluates to 4.4
        System.out.println(ret.getX());
        System.out.println(ret.getY());
    }
}
