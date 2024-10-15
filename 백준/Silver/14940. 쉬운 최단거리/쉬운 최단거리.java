import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0 ,0, -1, 1};
    static int x=0,y=0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];

        for(int i =0; i<n; i++){
            Arrays.fill(result[i],-1);
        }
        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    x =i;
                    y =j;
                    visited[i][j] =true;
                    result[i][j] =0;
                }
                if(map[i][j]==0){
                    result[i][j]=0;
                }
            }
        }
        bfs(x,y);
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(map[i][j] ==1 && result[i][j] ==-1){
                    result[i][j]=-1;
                }
                sb.append(result[i][j]).append(" ");

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void bfs(int i, int j){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[] {i,j});

        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            for(int d=0;d<4;d++){
                int nx = cx +dx[d];
                int ny = cy +dy[d];

                if(nx>=0 && nx <n && ny>=0 &&ny<m){
                    if(!visited[nx][ny] && map[nx][ny]==1){
                        visited[nx][ny] =true;
                        result[nx][ny]= result[cx][cy]+1;
                        q.offer(new int[] {nx,ny});
                    }
                }

            }



        }
    }
}