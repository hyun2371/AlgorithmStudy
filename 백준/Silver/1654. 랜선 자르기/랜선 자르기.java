import java.io.*;
import java.util.*;

class Main {
    public int count(int[] arr, long l){
        int cnt = 0;
        for (int x : arr){
            cnt+=x/l;
        }
        return cnt;
    }
    public long solution(int[] arr, int n, int k) { 
        long answer =0;
        long lt =1, rt = Arrays.stream(arr).max().getAsInt();
        while (lt<=rt){
            long mid = (lt+rt)/2;
            if (count(arr,mid)>=k){
                answer = mid;
                lt = mid+1;
            } 
            else rt = mid-1;
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
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(t.solution(arr,n,k));
        
        
        br.close();
    }
}