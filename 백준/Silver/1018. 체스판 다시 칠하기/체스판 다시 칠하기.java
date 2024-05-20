import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] c = new char[n][m];

        for (int i = 0; i < n; i++) {
            c[i] = br.readLine().toCharArray();
        }
        int minCount = Integer.MAX_VALUE;
        for (int row = 0; row < n - 7; row++) {
            for (int col = 0; col < m - 7; col++) {
                int cnt1 = 0; // 시작이 검은색일 때 다시 칠하는 개수
                int cnt2 = 0; // 시작이 흰색일 때 다시 칠하는 개수
                for (int i = row; i < row + 8; i++) {
                    for (int j = col; j < col + 8; j++) {
                        if ((i + j) % 2 == 0) {
                            if (c[i][j] == 'B') { // 시작 검은색
                                cnt1++;
                            }
                            if (c[i][j] == 'W') {
                                cnt2++;
                            }
                        } else {
                            if (c[i][j] == 'W') { // 시작 흰색
                                cnt1++;
                            }
                            if (c[i][j] == 'B') {
                                cnt2++;
                            }
                        }
                    }
                }
                minCount = Math.min(minCount, Math.min(cnt1, cnt2));
            }
        }

        System.out.println(minCount);
    }
}