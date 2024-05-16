import java.io.*;
import java.util.*;

class Main {	
    public String[] solution(String[] name, String[] q){
        String[] answer = new String[q.length];
        Map<String, String> map1 = new HashMap<>(); //숫자, 문자열
        Map<String, String> map2 = new HashMap<>();//문자열, 숫자
        for (int i=0;i<name.length;i++){
            map1.put(String.valueOf(i+1), name[i]);
            map2.put(name[i],String.valueOf(i+1));
        }

        for (int i=0;i<q.length;i++){
            if (Character.isDigit(q[i].charAt(0))){ // 키: 숫자
                answer[i] = map1.get(q[i]);
            } else { // 키: 문자열
                answer[i] = map2.get(q[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException{
        Main t = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        String[] name = new String[n];

        for (int i=0;i<n;i++){
            name[i] = br.readLine();
        }

        String[] q = new String[m];
        for (int i=0;i<m;i++){
            q[i] = br.readLine();
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : t.solution(name, q)){
            bw.write(s+"\n");
        }
        bw.flush();
    }
}