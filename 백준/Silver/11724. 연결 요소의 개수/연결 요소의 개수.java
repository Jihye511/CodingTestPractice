import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static  ArrayList<ArrayList<Integer>> node = new ArrayList<>();
    static int count;
    static boolean[] visited;
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            node.add(new ArrayList<>());
        }
        visited = new boolean[N+1];
        count =0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            node.get(a).add(b);
            node.get(b).add(a);
        }
        for(int i =1; i<=N;i++){
            if(!visited[i]){
                visited[i]=true;
                bfs(i);
            }
        }
        System.out.println(count);
    }
    public static void bfs(int n){
        for(int i =0; i<node.get(n).size(); i++){
            int a = node.get(n).get(i);
            q.offer(a);
        }
        while(!q.isEmpty()){
            int next = q.poll();
            if(!visited[next]){
                visited[next]=true;
                for(int i =0; i<node.get(next).size();i++){
                    int b = node.get(next).get(i);
                    q.offer(b);
                }
            }else continue;
        }
        count++; //단지 돌고 +1
    }
 }