class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        DFS(0, 0, numbers, target);
        return answer;
    }
    public static void DFS(int lv, int total, int[] arr, int target){
        if (lv==arr.length){
            if (total==target) {
                answer++;
            }
        } else {
            DFS(lv+1, total+arr[lv], arr, target);
            DFS(lv+1, total-arr[lv], arr, target);
        }
    }
}