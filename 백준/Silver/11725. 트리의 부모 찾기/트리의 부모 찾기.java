import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static ArrayList<Integer>[] node;
    static int[] ans;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        node = new ArrayList[N+1];
        ans = new int[N+1];
        visited = new boolean[N+1];
        for(int i =0; i<N+1; i++){
            node[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            node[a].add(b);
            node[b].add(a);
        }
        bfs(1);
        for(int i =2; i<=N; i++){
            System.out.println(ans[i]);
        }
    }
    public static void bfs(int n){
        visited[n]= true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        while(!q.isEmpty()){
            int current = q.poll();
            for(int i =0; i<node[current].size(); i++){
                int next = node[current].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    ans[next] = current;
                    q.offer(next);
                }
            }

        }
    }

}