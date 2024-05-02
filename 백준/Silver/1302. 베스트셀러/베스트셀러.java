import java.io.*;
import java.util.*;

class Main {
  public String solution(String[] arr, int n) {
    String answer="zzzzz";
    Map<String, Integer> map = new HashMap<>();
    for (String key : arr){
      map.put(key, map.getOrDefault(key,0)+1);
    }
    int maxCnt = Integer.MIN_VALUE;
    for (String key : map.keySet()){
      int value = map.get(key);
      if ((value>maxCnt)||(value==maxCnt&&key.compareTo(answer)<0)){
        maxCnt = value;
        answer = key;
      }
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main t = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] arr = new String[n];
    for (int i=0;i<n;i++){
      arr[i] = br.readLine();
    }
    System.out.println(t.solution(arr, n));
    
  }
}