import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<Event> history = new ArrayList<>();
        
        for (int i=0;i<record.length;i++){
            String[] arr = record[i].split(" ");
            String cmd = arr[0];
            String id = arr[1];
           
            if (cmd.equals("Enter")) {
                String name = arr[2];
                map.put(id,name);
                history.add(new Event(id, "님이 들어왔습니다."));
            }
            else if (cmd.equals("Leave")) {
                history.add(new Event(id, "님이 나갔습니다."));
            }
            else {
                String name = arr[2];
                map.put(id,name);
            }
        }
        
        String[] result = new String[history.size()];
        for (int i=0;i<result.length;i++){
            Event event = history.get(i);
            result[i] = map.get(event.id)+event.msg;
        }
        return result;
    } 
}

class Event{
    String id;
    String msg;
    public Event(String id, String msg){
        this.id = id;
        this.msg = msg;
    }
}