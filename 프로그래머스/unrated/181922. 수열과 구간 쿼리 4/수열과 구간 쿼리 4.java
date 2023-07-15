class Solution {
    public int[] solution(int[] arr, int[][] queries) {

        for (int i =0;i<queries.length;i++){
            int s = queries[i][0], e = queries[i][1], k = queries[i][2];
            for (int ind = s; ind<=e;ind++){
                if (ind%k==0) arr[ind]++;
            }
        }
        return arr;
    }
}