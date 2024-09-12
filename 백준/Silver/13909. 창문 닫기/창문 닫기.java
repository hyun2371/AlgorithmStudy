import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int answer = 0;
        for(int i = 1; i * i <= n; i++) { 
            answer++;
        }
        System.out.println(answer);
    }
}