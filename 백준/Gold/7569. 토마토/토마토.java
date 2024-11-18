import java.io.*;
import java.sql.PreparedStatement;
import java.util.*;

public class Main {
    static int M,N,H; //가로,세로,높이
    static int[][][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int count=0;
    static int [] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dh = {0,0,0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][M][H];
        for(int h = 0; h<H;h++){
            for(int i =0; i<N; i++){
                st= new StringTokenizer(br.readLine());
                for(int j =0; j<M; j++){
                    map[i][j][h] = Integer.parseInt(st.nextToken());
                    if(map[i][j][h] == 1){
                        q.offer(new int[]{i,j,h});
                    }
                }
            }
        }

        //모든 토마토 익어있는지 확인
        if(checkTomato()){
            System.out.println(0);
            return;
        }
        //bfs
        bfs();


        if(!checkTomato()){
            System.out.println(-1);
            return;
        }

        System.out.println(count-1);

    }

    public static void bfs(){
        while (!q.isEmpty()){
            int size =q.size();
            for(int i =0; i<size; i++){
                int[] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];
                int ch = cur[2];
                for(int d=0;d<6; d++){
                    int nx = cx +dx[d];
                    int ny = cy +dy[d];
                    int nh = ch +dh[d];

                    //범위
                    if(nx<0 || nx>=N || ny<0 || ny>=M || nh<0 || nh>=H) continue;
                    //0인지 확인
                    if(map[nx][ny][nh]==0){
                        map[nx][ny][nh]=1;
                        q.offer(new int[]{nx,ny,nh});
                    }
                }

            }
            count+=1;
        }
    }
    public static boolean checkTomato(){
        for(int h = 0; h<H;h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j][h]==0){
                        return false;

                    }
                }
            }
        }
        return true;
    }
}