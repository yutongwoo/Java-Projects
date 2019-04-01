package bearmaps;

import java.util.List;

public class KDTree {
    private boolean horizontal = false;
    private Node root;

    private class Node {
        private Point point;
        private boolean orientation;
        private Node LB; //LeftBottom
        private Node RT; //RightTop

        Node(Point p, boolean orient) {
            point = p;
            orientation = orient;
        }
    }
    public KDTree(List<Point> points) {
        for (Point p : points) {
            root = add(p, root, horizontal);
        }
    }

    private Node add(Point p, Node n, boolean orient) {
        if (n == null) {
            return new Node(p, orient);
        }
        if (p.equals(n.point)) {
            return n;
        }
        if (compare(p, n.point, orient) >= 0) {
            n.RT = add(p, n.RT, !orient);
        } else {
            n.LB = add(p, n.LB, !orient);
        }
        return n;
    }

    private int compare(Point a, Point b, boolean orientation) {
        if (orientation == horizontal) {
            return Double.compare(a.getX(), b.getX());
        } else {
            return Double.compare(a.getY(), b.getY());
        }
    }

    public Point nearest(double x, double y) {
        Point point = new Point(x, y);
        return nearesthelp(root, point, root.point);
    }

    private Point nearesthelp(Node n, Point origin, Point best) {
        if (n == null) {
            return best;
        }
        if (Point.distance(origin, n.point) < Point.distance(origin, best)) {
            best = n.point;
        }
        int compare = compare(origin, n.point, n.orientation);
        Node good;
        Node bad;
        if (compare < 0) {
            good = n.LB;
            bad = n.RT;
        } else {
            good = n.RT;
            bad = n.LB;
        }
        best = nearesthelp(good, origin, best);
        double bestdis, baddis;
        bestdis = Point.distance(origin, best);
        if (n.orientation == horizontal) {
            baddis = Point.distance(origin, new Point(origin.getX(), n.point.getY()));
        } else {
            baddis = Point.distance(origin, new Point(n.point.getX(), origin.getY()));
        }
        if (baddis < bestdis) {
            best = nearesthelp(bad, origin, best);
        }
        return best;
    }
}
