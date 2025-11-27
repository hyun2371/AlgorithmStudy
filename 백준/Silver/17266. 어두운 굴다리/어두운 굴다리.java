import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int[] arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = 0;
        
        // 1. 왼쪽 끝
        ans = Math.max(ans, arr[0]);
        
        // 2. 가로등 사이
        for (int i = 1; i < M; i++) {
            int diff = arr[i] - arr[i - 1];
            ans = Math.max(ans, (diff + 1) / 2);  // 올림 처리
        }
        
        // 3. 오른쪽 끝
        ans = Math.max(ans, N - arr[M - 1]);
        
        System.out.println(ans);
    }
}