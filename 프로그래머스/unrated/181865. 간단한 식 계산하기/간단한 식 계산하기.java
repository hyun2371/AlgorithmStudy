class Solution {
    public int solution(String binomial) {
        String[] arr = binomial.split(" ");

        int n1 = Integer.parseInt(arr[0]);
        int n2 = Integer.parseInt(arr[2]);

        if (arr[1].equals("+"))
            return n1+n2;
        else if (arr[1].equals("-"))
            return n1-n2;
        else 
            return n1*n2;
    }
}