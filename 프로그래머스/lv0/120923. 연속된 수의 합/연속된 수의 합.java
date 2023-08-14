class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int start = 0; 
        for (int i=-1000;i<1000;i++){
            int sum = i+(i+num-1);
            if (sum%2==0&& (sum/2*num)==total){
                start = i; break;
            }
            else if (sum%2==1 && (sum*num/2)==total){ 
                 start = i; break;
            }
            
        }
        for (int i=0;i<num;i++){
            answer[i] = start+i;
        }
        return answer;
    }
}