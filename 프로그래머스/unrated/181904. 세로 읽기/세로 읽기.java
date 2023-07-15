class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        String[] arr  = my_string.split("");
        int i =0;
        while (c+m*i-1<arr.length){
            answer+=arr[c+m*i-1];
            i++;
        }
        return answer;   
    }
}
/*
        m글자씩 가로 c번째 열
        2+4*i->2,6,10
        */