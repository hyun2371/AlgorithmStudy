import java.io.*;
import java.util.*;

class Main {
    //절단기 높이로 나무 길이 얼만큼 얻는지
    public static long sum(int[] arr, int h){
      long sum = 0;
      for (int x : arr){
          if (x>h) sum+=(x-h);
      }
      return sum;
    }
    public int solution(int[] arr, int k) { 
      int answer = 0; // 절단기 높이
      int lt = 0;
      int rt = Arrays.stream(arr).max().getAsInt();
      while (lt<=rt){
          int mid = (lt+rt)/2;
          if (sum(arr,mid)>=k){
              answer = mid;
              lt = mid+1;
          } 
          else {
              rt = mid-1;
          }
      }
      
      return answer;
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(t.solution(arr,k));
    }
}