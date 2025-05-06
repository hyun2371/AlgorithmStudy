import java.util.*;
public class Main {
    static int cnt;
    private static boolean[] visited;
    private static List<List<Integer>> graph = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); //정점 개수
        int M = sc.nextInt(); //간선 개수
        visited = new boolean[N+1];
        for (int i=0;i<=N;i++){
            graph.add(new LinkedList<>());
        }
        for (int i=0;i<M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        DFS(1);
        System.out.println(cnt);
    }

    private static void DFS(int v){
        for (int cv: graph.get(v)){
            if (!visited[cv]){
                if (cv!=1) cnt++;
                visited[cv] = true;
                DFS(cv);
            }
        }       
    }
}