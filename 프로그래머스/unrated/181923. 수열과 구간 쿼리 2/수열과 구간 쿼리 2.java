class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        /*
        각 quries.length 
            i -> s~e  min(arr[i]>=k)
        */
        
        int[] answer = new int[queries.length];
        
        for (int i =0;i<queries.length;i++){
            int min =10000000, minInd=0;
            
            for (int z = queries[i][0];z<=queries[i][1];z++){
                if (arr[z]>queries[i][2]){ //arr>k
                    if (arr[z]<min){ //min구하기
                        minInd = z;
                        min=arr[z];
                    }
                }
            }
            if (min==10000000) answer[i]=-1;
            else answer[i]=min;
        }
        return answer;
    }
}