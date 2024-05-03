import java.io.*;
import java.util.*;

class Main {
  public String solution(String[] arr, int n) {
    String answer = "";
    Map<String, Integer> map = new HashMap<>();
    for (String key : arr){
      map.put(key, map.getOrDefault(key,0)+1);
    }
    int maxCnt = 0;
    for (String key : map.keySet()){
      if (map.get(key)>maxCnt || map.get(key)==maxCnt && key.compareTo(answer)==1){
        maxCnt = map.get(key);
        answer = key+" "+maxCnt;
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