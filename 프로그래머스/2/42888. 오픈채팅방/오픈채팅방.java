import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> historyId = new ArrayList<>();
        List<String> historyPrefix = new ArrayList<>();
        
        for (int i=0;i<record.length;i++){
            String[] arr = record[i].split(" ");
            String cmd = arr[0];
            String id = arr[1];
           
            if (cmd.equals("Enter")) {
                String name = arr[2];
                map.put(id,name);
                historyId.add(id);
                historyPrefix.add("님이 들어왔습니다.");
            }
            else if (cmd.equals("Leave")) {
                historyId.add(id);
                historyPrefix.add("님이 나갔습니다.");
            }
            else {
                String name = arr[2];
                map.put(id,name);
            }
        }
        
        String[] result = new String[historyId.size()];
        for (int i=0;i<result.length;i++){
            result[i] = map.get(historyId.get(i))+historyPrefix.get(i);
        }
        return result;
    }
    
    
}