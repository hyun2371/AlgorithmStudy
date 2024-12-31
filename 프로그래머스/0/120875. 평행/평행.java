import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        if (isParallel(dots[0], dots[1], dots[2], dots[3])) return 1;
        if (isParallel(dots[0], dots[2], dots[1], dots[3])) return 1;
        if (isParallel(dots[0], dots[3], dots[1], dots[2])) return 1;

        return 0;
    }

    private boolean isParallel(int[] p1, int[] p2, int[] p3, int[] p4) {
        double slope1 = getSlope(p1, p2);
        double slope2 = getSlope(p3, p4);
        return slope1 == slope2;
    }

    private double getSlope(int[] p1, int[] p2) {
        return (double) (p2[1] - p1[1]) / (p2[0] - p1[0]);
    }
}