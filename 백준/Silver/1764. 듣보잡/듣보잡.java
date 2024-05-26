import java.io.*;
import java.util.*;

class Main {
    public Set<String> solution(String[] a, String[] b){
        Set<String> answer = new TreeSet<>();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (String s : a){ 
            set1.add(s);
        }
        for (String s:b){
            set2.add(s);
        }
        for (String s : set1){ 
            if (set2.contains(s)){
                answer.add(s);
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
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Set<String> ts = t.solution(a,b);
        bw.write(ts.size()+"\n");
        for (String s : ts){
            bw.write(s+"\n");
        }
        bw.close();
    }
}