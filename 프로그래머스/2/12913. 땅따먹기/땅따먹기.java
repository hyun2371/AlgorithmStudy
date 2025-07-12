import java.util.*;
class Solution {
    int solution(int[][] land) {
        int[][] d = new int[land.length][land[0].length]; //d[i][j]: i열 j행까지의 최대점수

        // 행=1일 경우 1행 정렬해서 바로 반환
        if (land.length==1){
            Arrays.sort(land[0]);
            return land[0][land[0].length-1];
        }
        
        // 초기항
        for (int c=0;c<land[0].length;c++){
            d[0][c] = land[0][c];
        }
        
        int answer = Integer.MIN_VALUE;
        for (int r=1;r<land.length;r++){ //행
            for (int c=0;c<land[0].length;c++){ //열
                
                int prevMax = Integer.MIN_VALUE; 
                for (int i=0;i<land[0].length;i++){ //이전행에서 최대값 구하기
                    if (i==c) continue; //같은 열 밟을 수 없음
                    prevMax = Math.max(d[r-1][i],prevMax);
                }
                d[r][c] = prevMax + land[r][c]; //이전 점수 최대값+ 현재 점수
                if (r==land.length-1) answer = Math.max(d[r][c],answer);
            }
            
        }
        
        return answer;
    }
}