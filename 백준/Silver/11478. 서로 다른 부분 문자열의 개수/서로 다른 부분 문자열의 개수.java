import java.io.*;
import java.util.*;

class Main {
    public int solution(String s){
       TreeSet<String> ts = new TreeSet<>();

        for (int k=1;k<=s.length();k++){
            for (int i=0;i<=s.length()-k;i++){
                ts.add(s.substring(i,i+k));
            }
        }
        
        return ts.size();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
        String s = br.readLine();
        System.out.println(t.solution(s));
    }
}