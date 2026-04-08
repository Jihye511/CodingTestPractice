import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    static int N,M,V;
    static ArrayList <Integer>[] node;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        node = new ArrayList[N+1];
        for(int i =0; i<=N; i++){
            node[i] = new ArrayList<>();
        }

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            node[a].add(b);
            node[b].add(a);
        }
        for(ArrayList<Integer> list : node){
            Collections.sort(list);
        }
        boolean[] v = new boolean[N+1];
        int[] num = new int[N+1];
        v[V] = true;
        dfs(V,v,0, num);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }
    static StringBuilder sb = new StringBuilder();
    public static void dfs(int start, boolean[] v, int depth, int[] num){
        sb.append(start).append(" ");
        if(depth ==N){
            return;
        }
        for(int i =0; i<node[start].size(); i++){
            int next = node[start].get(i);
            if(!v[next]){
                v[next] = true;
                num[depth] = next;
                dfs(next, v, depth+1, num);

            }
        }
    }
    public static void bfs(int start){
        Queue<Integer> q= new LinkedList<>();
        q.offer(start);
        boolean[] v = new boolean[N+1];
        v[start] = true;
        while(!q.isEmpty()){
            int cur= q.poll();
            sb.append(cur).append(" ");
            for(int i =0; i<node[cur].size(); i++){
                int next = node[cur].get(i);
                if(!v[next]){
                    v[next] = true;
                    q.offer(next);
                }
            }
        }

    }
}