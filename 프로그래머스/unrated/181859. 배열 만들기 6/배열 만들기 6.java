import java.util.*;
class Solution {
    public int[] solution(int[] arr) {

        List<Integer> lst = new ArrayList<>();
        for (int i =0;i<arr.length;i++){
            if (lst.size()==0){
                lst.add(arr[i]);
            } else {
                if (lst.get(lst.size()-1)==arr[i]){
                    lst.remove(lst.size()-1);
                }else{
                    lst.add(arr[i]);
                }
            }
        }
        if (lst.size()==0) return new int[]{-1};
        return lst.stream().mapToInt(x->x).toArray();
    }
}