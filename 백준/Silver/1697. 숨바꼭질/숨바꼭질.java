import java.util.*;

public class Main {
    static int[] dis = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 출발지
        int K = sc.nextInt(); // 목적지
        if (N == K) {
            System.out.println(0);
        } else {
            System.out.println(BFS(N, K));
        }
    }

    static int BFS(int start, int target) {
        Arrays.fill(dis, -1); // 모든 위치를 미방문 상태로 초기화
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dis[start] = 0; // 시작 지점 거리 초기화

        while (!q.isEmpty()) {
            int x = q.poll();
            int[] nextPositions = {x + 1, x - 1, 2 * x};

            for (int pos : nextPositions) {
                if (pos >= 0 && pos <= 100000 && dis[pos] == -1) {
                    dis[pos] = dis[x] + 1;
                    if (pos == target) {
                        return dis[pos];
                    }
                    q.add(pos);
                }
            }
        }
        return -1; // 이론적으로 도달할 수 없는 코드
    }
}
