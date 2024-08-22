import java.util.*;
import java.io.*;
public class Main {
    static int T,M,N,K;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-->0){
            count =0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());

            map= new int[N][M];
            //2차원 배열 초기화
            for (int i = 0; i < N; i++)
                Arrays.fill(map[i], 0);

            visited=new boolean[N][M];

            while(K-->0){ //map만들기
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b]=1;
            }
            //전체 검색-> 조건맞는 것만 dfs 보내기
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        visited[i][j]=true;
                        dfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void dfs(int x,int y){
        for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            //map 범위 벗어나면 패쓰
            if(nx<0 || ny<0 || nx>=N || ny >=M) continue;
            if(visited[nx][ny]) continue;
            if(!visited[nx][ny] && map[nx][ny]==1){
                visited[nx][ny] =true;
                dfs(nx,ny);
            }
        }
    }
}