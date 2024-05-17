import java.io.*;
import java.util.*;

class Main {	
    public int[] solution(int[] arr1, int[] arr2){
        int[] answer = new int[arr2.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr1){
            map.put(x, 1);
        }

        for (int i=0;i<arr2.length;i++){
            answer[i] = map.getOrDefault(arr2[i],0)==0?0:1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        Main t = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] line1 = br.readLine().split(" ");
        int[] arr1 = new int[n];
        
        for (int i=0;i<n;i++){
            arr1[i] = Integer.parseInt(line1[i]);
        }

        int m = Integer.parseInt(br.readLine());
        String[] line2 = br.readLine().split(" ");
        int[] arr2 = new int[m];
        
        for (int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(line2[i]);
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int x : t.solution(arr1, arr2)){
            bw.write(x+"\n");
        }
        bw.flush();
    }
}