import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] available;
    static int[][] graph; 

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        available = new boolean[102][102]; // 이동 가능 여부
        graph = new int[102][102];
        
        for (int[] data : rectangle) {// 겹치는 부분 채우기
            for (int y = data[1] * 2; y <= data[3] * 2; y++) {  // 2배로 늘려서 ㄷ으로 갈 수 있게 함
                for (int x = data[0] * 2; x <= data[2] * 2; x++) {
                    available[x][y] = true;
                }
            }
        }
        for (int[] data : rectangle) { // 내부 없애고 외곽만 남기기
            for (int y = data[1] * 2 + 1; y < data[3] * 2; y++) {
                for (int x = data[0] * 2 + 1; x < data[2] * 2; x++) {
                    available[x][y] = false;
                }
            }
        }

        BFS(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return graph[itemX * 2][itemY * 2] / 2; // 2배 늘린거 반영
    }
    
    public void BFS(int cx, int cy, int ix, int iy) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(cx, cy));
        graph[cx][cy] = 1;
        
        while (!queue.isEmpty()) {
            Pos current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                // 주어진 범위 넘지 않음 && 외곽선 && 기존에 방문하지 않음
                if (nx >= 0 && ny >= 0 && nx < 102 && ny < 102 && available[nx][ny] && graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[current.x][current.y] + 1;
                    queue.add(new Pos(nx, ny));
                }
            }
        }
    }
}

class Pos {
    int x, y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}