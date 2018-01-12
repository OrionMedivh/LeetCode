import java.util.HashMap;
import java.util.Map;

/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

/*
 * A line is determined by two factors,say y=ax+b
 * 
 * If two points(x1,y1) (x2,y2) are on the same line(Of course).
 * 
 * Consider the gap between two points.
 * 
 * We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled
 * since b is a constant
 * 
 * If a third point (x3,y3) are on the same line. So we must have y3=ax3+b
 * 
 * Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
 * 
 * Since a is a rational, there exists y0 and x0,
 * y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
 * 
 * So we can use y0&x0 to track a line;
 */

/**
 * 
 * This solution is flawed, due to the division 
 * and accuracy of double.
 * But Linkedin likes this answer more.
 *
 */

public class MaxPointsOnALineAlternative {
	public int maxPoints(Point[] points) {
		if (points == null) {
			return 0;
		}
		if (points.length <= 2) {
			return points.length;
		}

		int result = 0;
		for (int i = 0; i < points.length; i++) {
			Map<Double, Integer> map = new HashMap<>();
			int overlap = 0, samex = 0, localMax = 0;
			for (int j = i + 1; j < points.length; j++) {
				// no need to start with 0, since
				// it's guaranteed to find the global max.
				int x = points[j].x - points[i].x;
				int y = points[j].y - points[i].y;
				if (x == 0 && y == 0) {
					overlap++;
					continue;
				}
				if (x == 0) {
					samex++;
					continue;
				}
				double k;
				if (y == 0) {
					k = 0.0;
				} else {
					k = (double) y / (double) x;
				}
				if (map.containsKey(k)) {
					map.put(k, map.get(k) + 1);
				} else {
					map.put(k, 1);
				}
				localMax = Math.max(localMax, map.get(k));
			}
			result = Math.max(result, Math.max(localMax, samex) + overlap + 1);
		}
		return result;
	}
	
	public static void main(String[] args){
		MaxPointsOnALineAlternative s = new MaxPointsOnALineAlternative();
		Point a = new Point(2,3);
		Point b = new Point(3,3);
		Point c = new Point(-5,3);
		System.out.println(s.maxPoints(new Point[]{a,b,c}));
	}
}
