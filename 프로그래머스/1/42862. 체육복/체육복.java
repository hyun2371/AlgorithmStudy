import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        boolean[] isLeft = new boolean[n+1]; //여벌 있는지
        int unwearCnt = 0; 
        Set<Integer> lostSet = new HashSet<>();
        for (int id : lost)lostSet.add(id); //잃어버림
        
        //자기 여벌 처리
        for (int id : reserve){
            if (lostSet.contains(id)){ //여벌 사용
                lostSet.remove(id);
            } else {  //도난 당하지 않아 사용할 필요없음
                isLeft[id] = true;
            }
        }
        
        for (int id : lost){//잃어버린 학생에 대해
            if (!lostSet.contains(id)) continue; //자기 여벌 사용한 학생 제외
            if (id>1&&isLeft[id-1]) isLeft[id-1] = false; //왼쪽에서 빌릴 수 있는지
            else if (id<n&&isLeft[id+1]) isLeft[id+1] = false; //오른쪽에서 빌릴 수 있는지
            else unwearCnt++; //못 빌림
        }
        
        return n-unwearCnt; //전체-못 빌린 수
    }
}