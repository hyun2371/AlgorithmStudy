class Solution {
    public String solution(String myString, String pat) {
        String myStr = myString.toLowerCase(),p = pat.toLowerCase();
        int index=0;
        
        for (int i = 0;i<=myStr.length()-p.length();i++){
            if (myStr.substring(i,i+p.length()).equals(p)){
                index=i+p.length();
            }
        }
        return myString.substring(0,index);
    }
}