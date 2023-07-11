class Solution {
    public int solution(String binomial) {
        String[] arr = binomial.split(" ");

        String op = arr[1];
        int n1 = Integer.parseInt(arr[0]);
        int n2 = Integer.parseInt(arr[2]);

        if (op.equals("+"))
            return n1+n2;
        else if (op.equals("-"))
            return n1-n2;
        else 
            return n1*n2;
    }
}