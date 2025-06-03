import java.util.*;
public class Main {
    static List<List<Edge>> edges = new ArrayList<>();
    static int N;
    static boolean[] visited;
    static int[] dis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int c = sc.nextInt();
            edges.get(x).add(new Edge(y,c));
            edges.get(y).add(new Edge(x,c));
        }

        int fVertex = findLargestVertex(1).vertex;
        int diameter = findLargestVertex(fVertex).cost;

        System.out.print(diameter);
    }

    private static Edge findLargestVertex(int x){
        visited = new boolean[N+1];
        dis = new int[N+1];
        visited[x] = true;
        dis[x] = 0;
        dfs(x,0); //시작점으로부터의 거리 구함

        int farthestDis = -1;
        int farthestVertex=-1;
        for (int i=1;i<=N;i++){
            if (dis[i]>farthestDis){
                farthestDis = dis[i];
                farthestVertex = i;
            }
        }
        return new Edge(farthestVertex, farthestDis);
    }
    private static void dfs(int x, int totalDis){
        for (Edge edge : edges.get(x)){
            int nx = edge.vertex;
            int cost = edge.cost;
            if (!visited[nx]){
                visited[nx] = true;
                dis[nx] = totalDis+cost;
                dfs(nx,totalDis+cost);
            } 
        }
    }
}


class Edge {
    int vertex;
    int cost;

    public Edge(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }
}