import java.io.*;
class Main {	
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //요금
    String[] f = br.readLine().split(" ");
    int fa = Integer.parseInt(f[0]);
    int fb = Integer.parseInt(f[1]);
    int fc = Integer.parseInt(f[2]);

    int answer= 0, maxCnt = 0;
    int[] arr = new int[101]; // 시간

    for (int i=0;i<3;i++){
      String[] m = br.readLine().split(" ");
      int m1 = Integer.parseInt(m[0]);
      int m2 = Integer.parseInt(m[1]);
      for (int j=m1;j<m2;j++){
        arr[j]++;
      }
      maxCnt = Math.max(m2, maxCnt);
    }

    for (int i=1;i<=maxCnt;i++){
      if (arr[i]==1){
        answer += fa;
      }
      else if (arr[i]==2){
        answer+=(fb*2);
      } else if (arr[i]==3){
        answer+=(fc*3);
      }
     
    }
     System.out.println(answer);

  }
}