import java.io.*;
import java.util.*;

class Main {	
    public int solution(int[] a, int[] b){
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a){
            map.put(x, 1);
        }

        for (int x : b){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        for (int v : map.values()){
            if (v==1) answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        Main t = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        String[] line2 = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = Integer.parseInt(line2[i]);
        }

        String[] line3 = br.readLine().split(" ");
        int[] b = new int[m];
        for (int i=0;i<m;i++){
            b[i] = Integer.parseInt(line3[i]);
        }
        System.out.println(t.solution(a,b));
    }
}