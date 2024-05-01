import java.io.*;

class Main {
  public int solution(int[] a, int n, int k) {
    int answer=0, lt=0;
    int[] cnt = new int[100001]; //원소 등장 횟수 저장
    for (int rt=0; rt<n;rt++){
      int ind = a[rt]; //원소
      cnt[ind]++;
      while (cnt[ind]>k){ //원소 등장 횟수가 기준치로 줄 때까지
        cnt[a[lt]]--;//원소 등장 시 카운트 감소
        lt++; //원소 등장 +1까지 증가
      }
      answer = Math.max(answer,rt-lt+1); // 최대 길이
    }
    
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main t = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] line1 = br.readLine().split(" ");
    int n = Integer.parseInt(line1[0]);
    int k = Integer.parseInt(line1[1]);

    int[] a = new int[n];
    String[] line2 = br.readLine().split(" ");
    for(int i=0;i<n;i++){
       a[i] = Integer.parseInt(line2[i]);
    }
    System.out.print(t.solution(a,n,k));
    
  }
}