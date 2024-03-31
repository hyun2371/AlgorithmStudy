class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String b : babbling){
            if (available(b)) answer++;
        }
        return answer;
    }
    
    public boolean available(String str){
        
        String[] dicArr = {"aya", "ye", "woo", "ma"};
        for (String dic : dicArr){
            str = str.replaceAll(dic, " ");
        }
        str = str.replaceAll(" ","");
        
        return str.length()==0 ? true : false;
    }
}