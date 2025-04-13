import java.io.*;
import java.util.*;

public class Solution {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T =10;
        for(int t=1; t<=T; t++){
            int tc = Integer.parseInt(br.readLine());
            map = new int[16][16];
            for(int i=0; i<16; i++){
                String str = br.readLine();
                for(int j=0; j<16; j++){
                    map[i][j] = str.charAt(j) -'0';
                }
            }
            int ans = 0;
            if(bfs(1,1)){
                ans = 1;
            }
            System.out.println("#" + t+" " + ans);
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static boolean bfs(int x, int y){
        Queue<int[]> q= new LinkedList<>();
        map[x][y] = 1;
        q.offer(new int[]{x,y});
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i =0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || nx>=16 || ny<0 || ny>=16) continue;
                if(map[nx][ny] ==1) continue;

                if(map[nx][ny]==3) return true;

                map[nx][ny] = 1;

                q.offer(new int[]{nx,ny});

            }

        }
        return false;
    }
}
