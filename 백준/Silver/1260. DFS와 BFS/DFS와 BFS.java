import java.io.*;
import java.sql.PreparedStatement;
import java.util.*;

public class Main {
    static int N,M,V;
    static ArrayList<Integer>[] list;
    static StringBuilder sb_dfs = new StringBuilder();
    static StringBuilder sb_bfs = new StringBuilder();
    static boolean[] visited_dfs;
    static boolean[] visited_bfs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited_dfs = new boolean[N+1];
        visited_bfs = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i =0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);

        }
        for(int i =0; i<N+1; i++){
            Collections.sort(list[i]);
        }
//        sb_dfs.append(V);
        visited_dfs[V]=true;
        visited_bfs[V]=true;
        dfs(V);
        bfs(V);
        System.out.println(sb_dfs);
        System.out.println(sb_bfs);
    }
    public static void dfs(int v){
        sb_dfs.append(v).append(" ");
        for(int i =0; i<list[v].size(); i++){
            int n = list[v].get(i);
            if(!visited_dfs[n]){
                visited_dfs[n] =true;
                dfs(n);
            }
        }
    }
    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);

        sb_bfs.append(v).append(" ");
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i =0; i<list[cur].size(); i++){
                int n = list[cur].get(i);
                if(!visited_bfs[n]){
                    visited_bfs[n] =true;
                    q.offer(n);
                    sb_bfs.append(n).append(" ");
                }
            }
        }
    }
}