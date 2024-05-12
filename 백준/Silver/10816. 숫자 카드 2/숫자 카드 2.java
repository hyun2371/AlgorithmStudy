import java.io.*;
import java.util.*;

class Main {	
  public int[] solution(int[] arr1, int[] arr2, int n, int m){
    int[] answer = new int[m];
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int k : arr1){
      map.put(k, map.getOrDefault(k,0)+1);
    }

    int ind = 0;
    for (int k : arr2){
      answer[ind++] = map.getOrDefault(k,0);
    }
    return answer;
  }
  public static void main(String[] args) throws IOException{
    Main t = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    int[] arr1 = new int[n];
    String[] line1 = br.readLine().split(" ");
    for (int i=0;i<n;i++){
      arr1[i] = Integer.parseInt(line1[i]);
    }

    
    int m = Integer.parseInt(br.readLine());
    int[] arr2 = new int[m];
    String[] line2 = br.readLine().split(" ");
    for (int i=0;i<m;i++){
      arr2[i] = Integer.parseInt(line2[i]);
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int x : t.solution(arr1, arr2, n, m)){
      bw.write(String.valueOf(x));
      bw.write(" ");
    }
    bw.flush();
  }
}