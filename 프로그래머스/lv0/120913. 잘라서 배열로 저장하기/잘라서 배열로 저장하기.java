class Solution {
    public String[] solution(String my_str, int n) {

        int l = my_str.length()%n==0?
            my_str.length()/n : my_str.length()/n+1;
        String[] answer = new String[l];
        
        
        for (int i =0, ind = 0;i<l;i++,ind+=n){
            if (i==l-1){
                answer[i] = my_str.substring(ind,my_str.length());
            } else {
                answer[i] = my_str.substring(ind,ind+n);
            }
            
        }
        
        return answer;
    }
}