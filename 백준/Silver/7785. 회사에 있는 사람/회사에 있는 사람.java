import java.io.*;
import java.util.*;

class Main {	
    public List<String> solution(String[] name, String[] status, int n){
        Map<String, Integer> map = new HashMap<>();
        for (int i=0;i<n;i++){
            if (status[i].equals("enter"))
                map.put(name[i], 0);
            else
                map.remove(name[i]);
        }
        List<String> answer = new ArrayList<>(map.keySet());
        Collections.sort(answer, Collections.reverseOrder());
        return answer;
    }
    
    public static void main(String[] args) throws IOException{
        Main t = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] name = new String[n];
        String[] status = new String[n];
        for (int i=0;i<n;i++){
            String[] line = br.readLine().split(" ");
            name[i]=line[0];
            status[i]=line[1];
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : t.solution(name, status, n)){
            bw.write(s+"\n");
        }
        bw.flush();
    }
}