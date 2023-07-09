class Solution {
    public int[] solution(int[] num_list, int n) {
        int len = num_list.length%n==0
            ?(num_list.length/n):(num_list.length/n+1);
        int[] arr = new int[len];
        
        for (int i = 0;i<len;i++){
            arr[i] = num_list[i*n];
        }
        return arr;
    }
}