class Solution {
    public String solution(String a, String b) {
        //b 길이가 더 크도록
        if (a.length()>b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
   
        int sum = 0, add = 0;
        String answer = "";
        
        for (int i =b.length()-1;i>=0;i--){
            if (i-(b.length()-a.length())>=0){
                sum = a.charAt(i-(b.length()-a.length()))+b.charAt(i)-96+add;
            } else {
                sum = b.charAt(i)-48+add;
            }
            add = 0;
            if (sum>=10){
                add = 1;
                sum %= 10;
            }
            
            answer = String.valueOf(sum) + answer;
        }
        if (add>0) //길이 같을 때 반올림
            answer = String.valueOf(add) + answer;
        return answer;
    }
}