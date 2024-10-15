import java.io.*;
import java.util.*;

public class Main {
    static int N,M,V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean[] visited_bfs;
    static StringBuilder sb_dfs =new StringBuilder();
    static StringBuilder sb_bfs = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        V =Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        visited_bfs = new boolean[N+1];
        graph = new ArrayList[N+1];
        for(int i =0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i =0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i=1; i<N+1; i++){
            Collections.sort(graph[i]);
        }
        dfs(V);
        bfs(V);

        System.out.println(sb_dfs);
        System.out.println(sb_bfs);
    }
    public static void dfs(int now){
        sb_dfs.append(now).append(" ");
        visited[now] =true;
        for(int i =0; i<graph[now].size(); i++){
            int next = graph[now].get(i);
            if(!visited[next]){
                dfs(next);
            }
        }
    }
    public static void bfs(int now){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(now);
        visited_bfs[now]=true;
        while(!q.isEmpty()){
            int current = q.poll();
            sb_bfs.append(current).append(" ");
            for(int i =0; i<graph[current].size();i++){
                int next = graph[current].get(i);
                if(!visited_bfs[next]){
                    visited_bfs[next]=true;

                    q.offer(next);
                }
            }
        }
    }
}