import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int i_x,i_y;
    public static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j] = true;
        map[i][j]=0;
        while(!q.isEmpty()){
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];

            for(int k =0; k<4; k++){
                int nx = x +dx[k];
                int ny = y +dy[k];

                //미로 벗어난 경우 무시
                if(nx<0 || ny<0 || nx>=n || ny >=m) continue;
                //0인 경우 무시
                if (map[nx][ny] == 0) continue;
                //이미 방문한 경우 무시
                if(visited[nx][ny]) continue;
                //1인 경우 (처음 반복) 거리 기록
                q.offer(new int[]{nx, ny});
                map[nx][ny] = map[x][y] + 1;
                visited[nx][ny] = true;
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map=new int[n][m];
        visited = new boolean[n][m];
        //map에 입력값 집어넣기
        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //2인 인덱스 찾아서 bfs 호출
        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] ==2){
                    i_x=i;
                    i_y=j;
                }else if(map[i][j] ==0){
                    visited[i][j]=true;
                }
            }
        }
        bfs(i_x,i_y);
        
        
        //출력
        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!visited[i][j]){
                    map[i][j]=-1;
                }
            }
        }
        for(int i =0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}