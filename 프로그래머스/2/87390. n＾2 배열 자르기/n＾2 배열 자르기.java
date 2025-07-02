class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right-left+1);
        int[] answer = new int[len];
        for (int i=0;i<len;i++){
            long ind = (left+i);
            int r =  (int)(ind/n);
            int c = (int)(ind%n);
            answer[i] = Math.max(r,c)+1;
        }
        return answer;
    }
}