import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int cnt = 0, cur = 0;
        for (int x:section){
            if (cur<x){
                cur = x+m-1;
                cnt++;
            }
        }
        return cnt;
    }
}