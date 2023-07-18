class Solution {
    public String solution(String myString, String pat) {
        int ind = myString.lastIndexOf(pat);
        return myString.substring(0,ind)+pat;
    }
}