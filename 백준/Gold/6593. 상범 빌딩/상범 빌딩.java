import java.io.*;
import java.util.*;
public class Main {
    static int L,R,C;
    static char[][][] map;
    static boolean[][][] visited;
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            L=Integer.parseInt(st.nextToken());
            R=Integer.parseInt(st.nextToken());
            C=Integer.parseInt(st.nextToken());
            if(L==0 && R ==0 &&C ==0) return;

            map = new char[L][R][C];
            visited =new boolean[L][R][C];
            int s_x=-1,s_y=-1,s_l=-1;
            for(int i =0;i<L;i++){
                for(int j =0;j<R; j++){
                    String line =br.readLine();
                    for(int k = 0; k<C;k++){
                        map[i][j][k] = line.charAt(k);
                        if(map[i][j][k]=='S'){
                            s_x = j;
                            s_y=k;
                            s_l=i;
                        }
                    }
                }
                br.readLine();
            }
            bfs(s_l,s_x,s_y,0);
        }


    }
    public static void bfs(int z,int x, int y,int cnt){
        Queue<int[]> q= new LinkedList<>();
        visited[z][x][y] = true;
        q.offer(new int[]{z,x,y,cnt});
        while(!q.isEmpty()){
            int[] c = q.poll();

            for(int i =0; i<6;i++){
                int nz = c[0] +dz[i];
                int nx = c[1] +dx[i];
                int ny = c[2] +dy[i];
                int n = c[3];
                if(nz<0 || nz>=L || nx<0 || nx>=R || ny<0 ||ny>=C) continue;
                if(!visited[nz][nx][ny] && map[nz][nx][ny]!='#'){
                    visited[nz][nx][ny]=true;
                    if(map[nz][nx][ny]=='E'){
                        n+=1;
                        System.out.println("Escaped in "+ n + " minute(s).");
                        return;
                    }
                    q.offer(new int[] {nz,nx,ny,n+1});
                }
            }
        }
        System.out.println("Trapped!");
    }
}