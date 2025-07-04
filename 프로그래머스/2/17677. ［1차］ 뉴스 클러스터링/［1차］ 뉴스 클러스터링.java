import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        
        initMap(mapA, str1.toLowerCase());
        initMap(mapB, str2.toLowerCase());
        if (mapA.size()==0&&mapB.size()==0) return 65536;
        
        System.out.println(mapA);
        System.out.println(mapB);
        
        int multi = 0;
        for (String k : mapA.keySet()){
            multi+=Math.min(mapA.get(k),mapB.getOrDefault(k,0));
        }

        int union = getCnt(mapA)+getCnt(mapB)-multi;
        int answer = (int)((multi/(union*1.0)*65536));
        return answer;
    }
    
    private static void initMap(Map<String, Integer> map, String str){
        for (int i=0;i<str.length()-1;i++){
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i+1);
            if (!Character.isAlphabetic(ch1)||!Character.isAlphabetic(ch2)) continue;
            String key = ch1+""+ch2;
            map.put(key,map.getOrDefault(key,0)+1);
        }
    }
    
    private static int getCnt(Map<String, Integer> map){
        int cnt = 0;
        for (String k : map.keySet()){
            cnt+=map.get(k);
        }
        return cnt;
    }
}