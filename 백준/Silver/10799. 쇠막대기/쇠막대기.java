import java.io.*;
import java.util.*;

class Main {
    public int solution(String s) { 
        int answer = 0;
        Stack<Character> stk = new Stack<>();
        char[] cArr = s.toCharArray();
        for (int i=0;i<cArr.length;i++){
            if (cArr[i]=='('&&cArr[i+1]!=')') stk.push(cArr[i]);
            else if (cArr[i]==')'&&cArr[i-1]=='(') //레이저
                answer+=stk.size(); 
            else if (cArr[i]==')'){
                answer+=1;
                stk.pop();
            }
        }
       return answer;
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
        
        String s = br.readLine();
        System.out.println(t.solution(s));
    }
}