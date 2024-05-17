import java.io.*;
import java.util.*;

class Main {	
    public String solution(String[] parti, String[] fin){
        String answer ="";
        Map<String, Integer> map = new HashMap<>();
        for (String s : fin){ // 완주o 명단
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for (String k : parti){ // 참가자
            if (map.getOrDefault(k,0)==0){
                answer = k;
            } else {
                map.put(k, map.getOrDefault(k,0)-1); // 동명이인 고려
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        Main t = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] parti = new String[n];
        String[] fin = new String[n-1];
        
        
        for (int i=0;i<n;i++){
            parti[i] = br.readLine();
        }
        
        for (int i=0;i<n-1;i++){
            fin[i] = br.readLine();
        }
        
        System.out.println(t.solution(parti, fin));
    }
}