import java.io.*;
import java.util.*;
class Main {	
  public int solution(int[] a,int n, int m){
    int answer = 0;
    Arrays.sort(a);
    for (int p1 = 0; p1<n-1;p1++){
      int p2 = p1+1;
      while (p2<n){
        if (a[p1]+a[p2]==m){
          answer++; break;
        }
        else if (a[p1]+a[p2]<m) p2++;
        else break;
      }
    }
    
    return answer;
  }
  public static void main(String[] args) throws IOException{
    Main t = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    String[] input2 = br.readLine().split(" ");
    int m = Integer.parseInt(input2[0]);

    int[] a = new int[n];
    String[] input3 = br.readLine().split(" ");
    for (int i=0;i<n;i++){
      a[i] = Integer.parseInt(input3[i]);
    }
    
    System.out.println(t.solution(a,n,m));
  }
}