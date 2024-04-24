import java.io.*;
import java.util.*;
class Main {	
  public String solution(String[] arr, int n){
    String answer = "";
    int[] alpha = new int[26];
    for (String s : arr){
      int ind = s.charAt(0) - 'a';
      alpha[ind]++;
    }

    for (int i=0;i<26;i++){
      if (alpha[i]>=5) answer+=(char)('a'+i);
    }

    if (answer.length()==0) return "PREDAJA";
    return answer;
  }
  public static void main(String[] args) throws IOException{
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