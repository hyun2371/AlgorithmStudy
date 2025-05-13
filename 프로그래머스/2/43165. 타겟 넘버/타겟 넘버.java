class Solution {
    static int cnt, N;
    public int solution(int[] numbers, int target) {
        N = numbers.length;      
        DFS(0,0,target,numbers);
        
        return cnt;
    }
    
    private static void DFS(int lv, int total, int target,int[] numbers){
        
        if (lv==N){ 
            if (total==target) cnt++;
            return;
        }
        DFS(lv+1, total+numbers[lv], target, numbers);
        DFS(lv+1, total-numbers[lv], target, numbers);
    }
}