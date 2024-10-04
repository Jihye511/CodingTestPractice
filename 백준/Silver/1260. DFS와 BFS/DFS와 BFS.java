import java.io.*;
import java.util.*;
public class Main {
    static int n,m,v;
    static ArrayList<Integer> [] map;
    static boolean[] visited_dfs,visited_bfs;
    static StringBuilder sb_dfs = new StringBuilder();
    static StringBuilder sb_bfs = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        visited_dfs = new boolean[n+1];
        visited_bfs = new boolean[n+1];
        for(int i=0; i<n+1; i++){
            map[i] = new ArrayList<>();
        }
        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a].add(b);
            map[b].add(a);
        }
        for(int i=1; i<=n; i++){
            Collections.sort(map[i]);
        }
        dfs(v);
        bfs(v);
        System.out.println(sb_dfs);
        System.out.println(sb_bfs);
    }
    public static void dfs(int start){
        sb_dfs.append(start).append(" ");
        visited_dfs[start] = true;

        for(int i =0; i<map[start].size(); i++){
            int next=map[start].get(i);
            if(!visited_dfs[next]){
                dfs(next);
            }
        }

    }
    public static void bfs(int start){
        Queue<Integer> q= new LinkedList<>();
        visited_bfs[start]=true;
        q.offer(start);
        sb_bfs.append(start).append(" ");
        while(!q.isEmpty()){
            int current = q.poll();
            for(int i=0; i<map[current].size(); i++){
                int next = map[current].get(i);
                if(!visited_bfs[next]){
                    visited_bfs[next]=true;
                    q.offer(next);
                    sb_bfs.append(next).append(" ");
                }
            }
        }
    }

}