import java.io.*;
import java.util.*;

class Main {
    public String solution(int[] a, int n){
        int target = 1; 
        Stack<Integer> tmp = new Stack<>();
        Stack<Integer> origin = new Stack<>();
        for (int i=n-1;i>=0;i--){
            origin.add(a[i]);
        }


        while (target<=n){
            if (!origin.isEmpty()&& origin.peek()==target){ //origin에 존재
                origin.pop();
                target++;
            }
            else if (!tmp.isEmpty()&& tmp.peek()==target){ //tmp에 존재
                tmp.pop();
                target++;
            }
            else if (!origin.isEmpty()&&origin.peek()!=target){ // origin에 존재 x
                tmp.push(origin.pop());
            }
            else return "Sad";
        }
        return "Nice";
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
        System.out.println(t.solution(a, n));
    }
}