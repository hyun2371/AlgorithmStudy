class Solution {
    public String solution(String myString, String pat) {
        int index=0;
        
        for (int i = 0;i<=myString.length()-pat.length();i++){
            if (myString.substring(i,i+pat.length()).equals(pat)){
                index=i+pat.length();
            }
        }
        return myString.substring(0,index);
    }
}