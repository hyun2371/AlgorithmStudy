class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for (char c : s.toCharArray()){
            if (!Character.isAlphabetic(c)){
                answer+=c; continue;
            } 
            
            int add = c+n;
            if (Character.isLowerCase(c)){
                if (add>122) add = add-122+97-1;
            } else {
                if (add>90) add = add-90+65-1;
            }
            answer+=(char)(add);
        }
        return answer;
    }
}