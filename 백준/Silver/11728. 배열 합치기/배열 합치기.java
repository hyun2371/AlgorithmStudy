import java.util.*;
import java.io.*;

class Main {	
  public ArrayList<Integer> solution(int[] a, int[] b, int n, int m){
    ArrayList<Integer> answer = new ArrayList<>();
    int p1 =0, p2 = 0;
    while (p1<n && p2<m){ //한 쪽 배열 끝나기 전까지
      if (a[p1]<=b[p2]) answer.add(a[p1++]);
      else answer.add(b[p2++]);
    }
    // 남은 하나 배열 요소들 넣기 (->둘 중 하나만 실행됨)
    while (p1<n) answer.add(a[p1++]);
    while (p2<m) answer.add(b[p2++]);

    return answer;
  }
	public static void main(String[] args) throws IOException {
   Main t = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    int a[] = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i=0;i<n;i++){
      a[i]=Integer.parseInt(st.nextToken());
    }
    
    int b[] = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i=0;i<m;i++){
      b[i]=Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();
    for (int x : t.solution(a,b,n,m)){
      sb.append(x).append(" ");
    }
    System.out.println(sb.toString());
	}
}