class Solution {
    public int[] solution(int[] array) {
        int maxInd = 0;
        int max = 0;
        for (int i = 0;i<array.length;i++){
            if (array[i]>max){
                max = array[i];
                maxInd = i;
            }
        }
        return new int[]{max,maxInd};
    }
}