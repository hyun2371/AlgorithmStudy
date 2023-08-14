class Solution {
    public int solution(int[] common) {
        int answer, l = common.length;
        int n1 = common[l-1], n2 = common[l-2], n3 = common[l-3];
        if (n1-n2 == n2-n3)
            answer = n1+(n1-n2);
        else
            answer = n1*(n1/n2);
        return answer;
    }
}
