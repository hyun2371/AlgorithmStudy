import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<User> users = new ArrayList<>();
        Set<Integer> stopIdxs = new HashSet<>();
        
        // String -> idx 연결
        Map<String, Integer> map = new HashMap<>();
        for (int i=0;i<id_list.length;i++){
            map.put(id_list[i],i);
            users.add(new User());
        }
         
        // 내가 신고한 유저, 날 신고한 유저 리스트 초기화
        for (String r : report){
            int reporterIdx = map.get(r.split(" ")[0]);
            int targetIdx = map.get(r.split(" ")[1]);
            User reporter = users.get(reporterIdx);
            User target = users.get(targetIdx);
            
            if (target.beReported.contains(reporterIdx)) continue; //중복 불가
            target.beReported.add(reporterIdx); 
            reporter.report.add(targetIdx);
            
            if (target.beReported.size()>=k){//정지 유저 추리기
                stopIdxs.add(targetIdx);
            }   
        }
        
        // 각 유저당 정지된 인원 몇 명 신고했는지
        int[] answer = new int[users.size()];
        for (int i=0;i<users.size();i++){
            User u = users.get(i);
            for (int stopIdx:stopIdxs){
                if (u.report.contains(stopIdx))
                    answer[i]++;
            }
        }
        
        return answer;
    }
}

class User {
    List<Integer> report = new ArrayList<>();
    List<Integer> beReported = new ArrayList<>();
}