import java.util.*;
import java.io.*;
class Main {	
  public int solution(int[] a,int n, int k){
    int sum = 0;
    for (int i=0;i<k;i++){
      sum += a[i];
    }
    int answer = sum;
    for (int i=k;i<n;i++){
      sum = sum + a[i] - a[i-k];
      answer = Math.max(sum, answer);
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