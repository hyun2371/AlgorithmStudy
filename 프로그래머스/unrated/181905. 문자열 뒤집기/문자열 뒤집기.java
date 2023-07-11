class Solution {
    public String solution(String my_string, int s, int e) {
        
        String r = my_string.substring(s,e+1);
        StringBuffer r_sb = new StringBuffer(r);
        String answer = my_string.substring(0,s)+r_sb.reverse()
            +my_string.substring(e+1,my_string.length());
        return answer;
    }
}