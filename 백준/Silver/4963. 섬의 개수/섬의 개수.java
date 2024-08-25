import java.util.*;
import java.io.*;
public class Main {
    static int w,h;
    static int[][] map;
    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {0,0,-1,1,-1,1,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            int count=0;
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0){
                return;
            }

            map=new int[h][w];
            visited = new boolean[h][w];
            for(int i =0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j =0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i =0; i<h; i++){
                for(int j =0; j<w; j++){
                    if(!visited[i][j] && map[i][j] ==1){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void dfs(int x, int y){
        visited[x][y]=true;
        for(int i =0;i<8; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            //조건1. 지도밖으로 나가면 continue;
            if(nx<0 || ny<0 || nx>=h || ny>=w) continue;
            if(map[nx][ny] ==1 && !visited[nx][ny]){
                dfs(nx,ny);
            }
        }
    }
 }