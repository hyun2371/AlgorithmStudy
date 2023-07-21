class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        int ind =0;
        
        for (int i = 0; i<picture.length;i++){
            String s = "";
            
            //answer원소
            for (char c : picture[i].toCharArray()){
                s+= String.valueOf(c).repeat(k);
            }
            
            //answer 원소 k번 삽입
            for (int j = 0;j<k;j++)
                answer[ind++] = s;
            
        }
        return answer;
    }
}