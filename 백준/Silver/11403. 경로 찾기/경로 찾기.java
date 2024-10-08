import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        N= Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0;j <N; j++){
                map[i][j] =Integer.parseInt(st.nextToken());
            }
        }
        for(int i =0; i<N; i++){
            bfs(i);
        }

        for(int i =0; i<N; i++){
            for(int j = 0; j<N; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void bfs(int node){
        visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<N;i++){
            if(map[node][i]==1) q.offer(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next=0; next<N; next++){
                if(map[cur][next]==1){
                    if(!visited[next]) {
                        visited[next] = true;
                        map[node][next] = 1;
                        q.offer(next);
                    }

                }
            }
        }
    }
}