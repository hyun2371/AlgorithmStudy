import java.io.*;
import java.util.*;
class Main {	
  public int solution(int[] a, int n, int k){
    int answer = 0, sum = 0, lt = 0, rt = 0;
    while (true){
      if (sum>=k) sum-=a[lt++];
      else if (rt==n) break;
      else if (sum<k) sum+=a[rt++];
      
      if (sum==k) answer++;
    }
    return answer;
  }
  public static void main(String[] args) throws IOException{
    Main t = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line1 = br.readLine().split(" ");
    int n = Integer.parseInt(line1[0]);
    int k = Integer.parseInt(line1[1]);

    int[] a = new int[n];
    String[] line2 = br.readLine().split(" ");
    for (int i=0;i<n;i++){
      a[i] = Integer.parseInt(line2[i]);
    }

    System.out.println(t.solution(a,n,k));
  }
}