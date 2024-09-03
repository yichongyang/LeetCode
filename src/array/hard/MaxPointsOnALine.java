package array.hard;

/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that
lie on the same straight line.

Example 1:

Input: points = [[1,1],[2,2],[3,3]]
Output: 3
Example 2:

Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4

Constraints:
1 <= points.length <= 300
points[i].length == 2
-104 <= xi, yi <= 104
All the points are unique.
 */
public class MaxPointsOnALine {
    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int max = 2;
        for (int i = 0; i < n; i++) {
            int samePoint = 1;
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                long x1 = points[i][0];
                long y1 = points[i][1];
                long x2 = points[j][0];
                long y2 = points[j][1];
                if (x1 == x2 && y1 == y2) {
                    samePoint++;
                } else {
                    count++;
                    for (int k = j + 1; k < n; k++) {
                        long x3 = points[k][0];
                        long y3 = points[k][1];
                        if ((y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1)) {
                            count++;
                        }
                    }
                }
                max = Math.max(max, count + samePoint);
            }
        }
        return max;
    }
}
