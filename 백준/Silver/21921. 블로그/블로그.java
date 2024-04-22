import java.util.*;
import java.io.*;
class Main {	
  public ArrayList<Integer> solution(int[] a,int n, int x){
    ArrayList<Integer> answer = new ArrayList<>();
    int sum = 0;
    for (int i=0;i<x;i++) sum+=a[i]; // 윈도우 초기합
    int cnt = 1, max = sum;
    
    for (int i=x;i<n;i++){
      sum=sum+a[i]-a[i-x];
      if (sum>max){
        max = sum;
        cnt=1;
      }
      else if (sum==max) cnt++;
    }
    if (max==0) answer.add(-1);
    else {
      answer.add(max);
      answer.add(cnt);
    }
    return answer;
  }
  public static void main(String[] args) throws IOException{
    Main t = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int x = Integer.parseInt(input[1]);

    int[] a = new int[n];
    String[] input2 = br.readLine().split(" ");
    for (int i=0;i<n;i++){
      a[i] = Integer.parseInt(input2[i]);
    }
    
    for (Integer i : t.solution(a,n,x)){
      if (i==-1) System.out.println("SAD");
      else System.out.println(i);
    }
  }
}