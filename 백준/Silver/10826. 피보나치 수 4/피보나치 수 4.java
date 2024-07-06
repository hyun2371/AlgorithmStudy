import java.io.*;
import java.math.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger[] arr = new BigInteger[10001];
        arr[0] = new BigInteger("0");
        arr[1] = new BigInteger("1");
        for (int i=2;i<=n;i++){
            arr[i] = arr[i-2].add(arr[i-1]);
        }
        System.out.println(arr[n]);
    }
}