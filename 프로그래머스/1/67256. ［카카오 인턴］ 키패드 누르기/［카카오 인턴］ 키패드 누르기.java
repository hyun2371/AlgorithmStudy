class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10, right = 12;
        boolean isLeft = true;

        for (int cur : numbers){
            if (cur==0) cur = 11; // 0->11
            if (cur%3==1) { //왼쪽
                isLeft = true;
            }
            else if (cur%3==0) { //오른쪽
                isLeft = false;
            }
            else{
                int leftDis = Math.abs(left-cur)/3+Math.abs(left-cur)%3;
                int rightDis = Math.abs(right-cur)/3+Math.abs(right-cur)%3;
                if (leftDis<rightDis||(leftDis==rightDis&&hand.equals("left"))){
                    isLeft = true;
                }
                else isLeft = false;
            }
            if (isLeft){
                sb.append('L');
                left = cur;
            } else {
                sb.append('R');
                right = cur;
            }
        }
        return sb.toString();
    }
}