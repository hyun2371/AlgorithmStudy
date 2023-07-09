class Solution {
    public String solution(String n_str) {
        while (true){
            if (n_str.charAt(0)=='0'){
                n_str = n_str.substring(1);
            } else {
                return n_str;
            }
        }
    }
}