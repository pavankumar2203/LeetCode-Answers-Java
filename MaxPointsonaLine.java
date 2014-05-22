/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        class Point1 extends Point implements Comparable<Point1> {
            public Point1(Point p) {
                this.x = p.x;
                this.y = p.y;
            }

            @Override
            public int compareTo(Point1 that) {
                return this.x - that.x;
            }
        }
        Point[] ps = new Point1[points.length];
        for (int i = 0; i < points.length; i++) {
            ps[i] = new Point1(points[i]);
        }
        Arrays.sort(ps);

        if (ps.length < 3) {
            return ps.length;
        }

        int max = 2;
        for (int i = 0; i < ps.length - 1; i++) {
            int nan = 0;
            int dup = 0;
            int rIndex = 0;
            double[] rs = new double[ps.length];
            for (int j = i + 1; j < ps.length; j++) {
                if (ps[j].x == ps[i].x && ps[j].y == ps[i].y)
                    dup++;
                else if (ps[j].x == ps[i].x)
                    nan++;
                else {
                    rs[rIndex++] = (ps[j].y - ps[i].y) * 1.0 / (ps[j].x - ps[i].x);
                }
            }
            max = Math.max(max, nan + 1);
            rs = Arrays.copyOfRange(rs, 0, rIndex);
            max = Math.max(max, maxDupCount(rs) + 1 + dup);
        }

        return max;
    }

    private int maxDupCount(double[] arr) {
        Arrays.sort(arr);
        if (arr.length < 2) return arr.length;
        int max = 0;
        int cur = 0;
        int i = 1;
        while (i < arr.length) {
            if (almostEqual(arr[i], arr[i - 1])) {
                cur++;
            } else {
                max = Math.max(max, cur + 1);
                cur = 0;
            }
            i++;
        }
        max = Math.max(max, cur + 1);
        return max;
    }

    private boolean almostEqual(double a, double b) {
        double diff = Math.abs(a - b);

        return diff < 1E-7;
    }
}
