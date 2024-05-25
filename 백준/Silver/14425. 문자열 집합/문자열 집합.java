import java.io.*;
import java.util.*;

class Main {
    public int solution(String[] a, String[] b){
        int answer = 0;
       Set<String> set = new HashSet<>();
        for (String s : a){ 
            set.add(s);
        }
        for (String s : b){ 
            if (set.contains(s)){
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        String[] a = new String[n]; 
        
        for (int i = 0; i < n; i++) {
            a[i]= br.readLine();
        }

        String[] b = new String[m]; 
        for (int i=0;i<m;i++){
            b[i] = br.readLine();
        }
        System.out.println(t.solution(a,b));
    }
}