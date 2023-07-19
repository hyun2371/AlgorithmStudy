import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        List<Integer> x_lst = new ArrayList<>();
        List<Integer> y_lst = new ArrayList<>();
        
        for (int i =0;i<dots.length;i++){
            int x = dots[i][0];
            int y = dots[i][1];
            if (x_lst.isEmpty()||x_lst.get(0)!=x){
                x_lst.add(x);
            }
            if (y_lst.isEmpty()||y_lst.get(0)!=y){
                y_lst.add(y);
            }
        }
        return Math.abs(x_lst.get(0)-x_lst.get(1))*Math.abs(y_lst.get(0)-y_lst.get(1));
    }
}