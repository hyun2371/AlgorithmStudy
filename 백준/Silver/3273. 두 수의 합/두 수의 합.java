import java.io.*;
import java.util.*;
class Main {	
  public int solution(int[] a, int n, int x){
   int answer = 0;
   Arrays.sort(a);
   for (int lt = 0; lt<n-1&&a[lt]<x/2+1;lt++){
     for (int rt = lt+1; rt<n;rt++){
       if (a[lt]+a[rt]==x){
         answer++; break;
       }
       else if (a[lt]+a[rt]>x) break;
     }
   }
    return answer;
  }
  public static void main(String[] args) throws IOException{
    Main t = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    
    int[] a = new int[n];
    String[] line = br.readLine().split(" ");
    for (int i=0;i<n;i++){
      a[i] = Integer.parseInt(line[i]);
    }
    
    int x = Integer.parseInt(br.readLine());
    
    System.out.println(t.solution(a,n,x));
  }
}