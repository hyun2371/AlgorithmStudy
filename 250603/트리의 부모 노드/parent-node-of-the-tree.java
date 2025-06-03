import java.util.*;
public class Main {
    static int[] parent;
    static boolean[] visited;
    static List<List<Integer>> edges = new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        parent = new int[N+1];
        visited = new boolean[N+1];
        
        for (int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for (int i=0;i<N-1;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            edges.get(x).add(y);
            edges.get(y).add(x);
        }

        dfs(1);
        visited[1] = true;

        for (int i=2;i<=N;i++){
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int x){
        for (int nx : edges.get(x)){
            if (!visited[nx]){
                visited[nx] = true;
                parent[nx] = x;
                dfs(nx);
            }   
        }
    }
}