import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
    int end;
    int weight;
    public Node(int end, int weight){
        this.end= end;
        this.weight=weight;
    }
    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
public class Main{
    static int V,E,K;
    //map을 2차원배열에 저장할지... 아니면 arrayList로 저장할지... ,고민 (2차원 배열 메모리 터짐)

    static int val =Integer.MAX_VALUE;
    static boolean[] visited;
    static List<Node>[] list;
    static int[] dist;
    private static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V =Integer.parseInt(st.nextToken());
        E =Integer.parseInt(st.nextToken());
        list = new ArrayList[V + 1];
        dist = new int[V + 1];

        Arrays.fill(dist, INF);

        for(int i = 1; i <= V; i++){
            list[i] = new ArrayList<>();
        }
        visited = new boolean[V+1];
        K = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // start에서 end로 가는 weight 가중치
            list[start].add(new Node(end, weight));
        }
        StringBuilder sb = new StringBuilder();
        bfs(K);
        // 출력 부분
        for(int i = 1; i <= V; i++){
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.println(sb);
    }
    public static void bfs(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));
        dist[start] = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.end;
            int time =cur.weight;
            if(visited[x] == true) continue;
            visited[x] = true;

            for(Node node : list[x]){
                if(dist[node.end] > dist[x] + node.weight){
                    dist[node.end] = dist[x] + node.weight;
                    q.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}