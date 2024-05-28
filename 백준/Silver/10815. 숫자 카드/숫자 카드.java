import java.io.*;
import java.util.*;

class Main {
    public int[] solution(int[] a, int[] b){
        int[] answer = new int[b.length];
        Set<Integer> set = new HashSet<>();
        for (int x : a){
            set.add(x);
        }
    
        int ind = 0;
        for (int x : b){
            answer[ind++] = set.contains(x)?1:0;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] b = new int[m];
       for (int i=0;i<m;i++){
           b[i] = Integer.parseInt(st.nextToken());
       }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        for (int x : t.solution(a,b)){
            bw.write(x+" ");
        }
        bw.close();
    }
}