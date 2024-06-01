import java.io.*;
import java.util.*;

class Main {
    public double solution(String s, int[] numArr) { 
        Stack<Double> stk = new Stack<>();
        char[] cArr = s.toCharArray();
        for (int i=0;i<s.length();i++){
            if (cArr[i] >='A' && cArr[i]<='Z'){
                stk.push(numArr[cArr[i]-'A']*1.0);
            }
            else {
                double rt = stk.pop(); 
                double lt = stk.pop();
                switch(cArr[i]){
                    case '*': stk.push(lt*rt); break;
                    case '-': stk.push(lt-rt); break;
                    case '+': stk.push(lt+rt); break;
                    case '/': stk.push(lt/rt); break;
                }
            }
        }
        return stk.get(0);
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
        
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] numArr = new int[n];
        for (int i=0;i<n;i++){
            numArr[i] = Integer.parseInt(br.readLine());
        }
        t.solution(s, numArr);
        System.out.printf("%.2f",t.solution(s, numArr));
    }
}

