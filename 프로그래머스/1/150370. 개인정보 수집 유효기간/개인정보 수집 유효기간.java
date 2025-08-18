import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> lst = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        initMap(termMap, terms);
        int limit = getTotal(today,0);
    
        for (int i=0;i<privacies.length;i++){
            String cal = privacies[i].split(" ")[0];
            int addM = termMap.get(privacies[i].split(" ")[1]);
            if (getTotal(cal,addM)<=limit){
                lst.add(i+1);
            }
        }    
        
        return getAnswer(lst);
    }
    
    private int[] getAnswer(List<Integer> lst){
        int[] answer = new int[lst.size()];
        for (int i=0;i<lst.size();i++){
            answer[i] = lst.get(i);
        }
        return answer;
    }
    
    private static void initMap(Map<String,Integer> termMap, String[] terms){
         for (int i=0;i<terms.length;i++){
            termMap.put(terms[i].split(" ")[0],Integer.parseInt(terms[i].split(" ")[1]));
        }
        System.out.println(termMap);
    }
    
    private static int getTotal(String cal, int addM){
        int total = addM*28;
        String[] date = cal.split("\\.");
        return total
            +Integer.valueOf(date[0])*12*28
            +Integer.valueOf(date[1])*28
            +Integer.valueOf(date[2]);
    }
}