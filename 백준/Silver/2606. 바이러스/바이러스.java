//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.*;
public class Main {
    static int n,cnt,vertex;
    static ArrayList<Integer>[] node;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        node = new ArrayList[n+1];
        visited = new boolean[n+1];
        vertex = Integer.parseInt(br.readLine());
        for(int i =0; i<n+1; i++){
            node[i] = new ArrayList<>();
        }
        for(int i =0;i<vertex;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            node[a].add(b);
            node[b].add(a);
        }
        bfs(1);
        System.out.println(cnt);
    }
    public static void bfs(int c){
        visited[c] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(c);
        while(!q.isEmpty()){
            int com = q.poll();
            for(int i =0; i<node[com].size(); i++){
                int next =node[com].get(i);
                if(!visited[next]){
                    visited[next]=true;
                    q.offer(next);
                    cnt+=1;
                }
            }

        }
    }
}