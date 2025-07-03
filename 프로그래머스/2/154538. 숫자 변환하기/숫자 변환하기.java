import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int[] d = new int[y+1]; //x->i에 필요한 최소 연산횟수 d[i]
        Arrays.fill(d,y+1);
        d[x] = 0;
        for (int i=x;i<=y;i++){
            if (2*i<=y)
                d[2*i] = Math.min(d[i]+1,d[2*i]);
            if (3*i<=y)
                d[3*i] = Math.min(d[i]+1,d[3*i]);
            if (i+n<=y)
                d[i+n] = Math.min(d[i]+1,d[i+n]);
        }
        if (d[y]==y+1) return -1;
        return d[y];
    }
}