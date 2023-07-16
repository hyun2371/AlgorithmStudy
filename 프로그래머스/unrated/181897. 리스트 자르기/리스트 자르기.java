import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0], b = slicer[1], c = slicer[2];
        List<Integer> lst = new ArrayList<>();
        
        int start, end, add=1;
        
        if (n==1){
            start =0;
            end = b;
        } else if (n==2){
            start=a;
            end = num_list.length-1;
        } else if (n==3){
            start = a;
            end = b;
        } else {
            start=a;
            end = b;
            add=c;
        }
        
        for (int i =start;i<=end;i+=add){
            lst.add(num_list[i]);
        }
        return lst.stream().mapToInt(x->x).toArray();
    }
}