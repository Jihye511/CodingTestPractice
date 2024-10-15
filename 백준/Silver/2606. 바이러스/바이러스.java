import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int cnt=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int node = Integer.parseInt(br.readLine());
        int vertex = Integer.parseInt(br.readLine());
        graph = new ArrayList[node+1];
        visited = new boolean[node+1];
        for(int i =0; i<node+1;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i =0; i<vertex; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);
        System.out.println(cnt);
    }
    public static void dfs(int now){
        visited[now] =true;
        for(int i =0;i<graph[now].size();i++){
            int next = graph[now].get(i);
            if(!visited[next]){
                cnt+=1;
                dfs(next);

            }
        }
    }

}