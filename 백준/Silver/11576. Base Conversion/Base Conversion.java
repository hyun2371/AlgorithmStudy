import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int decimal = 0;

        for (int i = 0; i < m; i++) {
            int square = m - i - 1;
            decimal += (int) (Math.pow(a, square) * (Integer.parseInt(st.nextToken())));
        }

        while (decimal > 0) {
            stack.push(decimal % b);
            decimal /= b;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}