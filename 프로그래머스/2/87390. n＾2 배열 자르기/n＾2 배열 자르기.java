class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right-left+1);
        int[] answer = new int[len];
        int ind =0;
        int startI = (int)(left/n);
        int startJ = (int)(left%n);
        boolean flag = false;
        
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i==startI&&j==startJ) flag = true; //시작점
                if (flag){
                    answer[ind++] = Math.max(i,j)+1;
                    if (ind==len) return answer;
                }  
            }
        }
        return answer;
    }
}