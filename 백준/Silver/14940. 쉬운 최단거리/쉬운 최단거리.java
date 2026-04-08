import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    static int n,m;
    static int[][] map;
    static int sx,sy;
    static int[][] ans;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        ans = new int[n][m];
        boolean[][] v = new boolean[n][m];
        for(int i =0; i<n; i++){
            Arrays.fill(ans[i],-1);
        }
        for(int i =0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j =0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    sx = i;
                    sy = j;
                    ans[sx][sy] = 0;
                }
                if(map[i][j]==0) ans[i][j]=0;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        map[sx][sy] =0;
        int[] nx = {-1,1,0,0};
        int[] ny = {0,0,-1,1};
        q.offer(new int[]{sx,sy,0});
        v[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int amount = cur[2];

            for(int i =0; i<4; i++){
                int dx = cx + nx[i];
                int dy = cy + ny[i];
                if(dx<0 || dx>=n || dy<0 ||dy>=m) continue;
                if(v[dx][dy]) continue;
                if(map[dx][dy] == 0) continue;
                if(ans[dx][dy] != -1) continue;
                v[dx][dy] = true;
                ans[dx][dy] = amount+1;
                q.offer(new int[] {dx,dy,amount+1});
            }
        }
        for(int[] raw : ans){
            for(int i : raw){
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}