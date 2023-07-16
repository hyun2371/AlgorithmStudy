class Solution {
    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();
        String[] arr = {".-","-...","-.-.","-..",".","..-.",
                "--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",
                ".--","-..-","-.--","--.."};
        
        for (String s: letter.split(" ")){
            for (int i =0;i<arr.length;i++){
                if (s.equals(arr[i])){
                    sb.append((char)('a'+i));
                }
            }
        }
        return sb.toString();
    }
}