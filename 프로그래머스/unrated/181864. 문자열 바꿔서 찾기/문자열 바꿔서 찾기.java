class Solution {
    public int solution(String myString, String pat) {
        String nStr = "";
        for (int i = 0;i<myString.length();i++){
            if (myString.charAt(i)=='A'){
                nStr+='B';
            } else {
                nStr+='A';
            }
        }
        return nStr.contains(pat)?1:0;
    }
}