import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]); // 저장할 사이트 수
        int m = Integer.parseInt(line[1]); // 찾을 사이트 주소 수

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] arr1 = br.readLine().split(" ");
            map.put(arr1[0], arr1[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String line2 = br.readLine();
            sb.append(map.get(line2)).append("\n");
        }

        System.out.print(sb.toString());
    }
}