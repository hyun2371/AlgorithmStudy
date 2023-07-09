class Solution {
    public String solution(String myString) {
        String answer = "";
        for (int i =0 ;i<myString.length();i++){
            String s = myString.charAt(i)+"";

            if (s.equals("a")||s.equals("A")){
                answer+=s.toUpperCase();
            } else{
                answer+=s.toLowerCase();
            }
        }
        return answer;
    }
}