import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0 ,0,-1,1};
    static Queue<int[]> q= new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==1){
                    q.offer(new int[] {i,j});
                }
            }
        }
        int result = bfs();
        //토마토 모두 익었나 확인 안익었음 -1
        if(!checkAll()){
            System.out.println(-1);
            return;
        }
        //최소날짜 출력
        System.out.println(result);
    }
    public static int bfs(){
        int cnt=0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                int[] current = q.poll();
                int cx = current[0];
                int cy = current[1];
                for(int d =0; d<4; d++){
                    int nx = cx +dx[d];
                    int ny = cy +dy[d];
                    //범위안에 있을 때
                    if(nx>=0 && nx<M && ny>=0 && ny<N) {
                        if(map[nx][ny]==0) {
                            map[nx][ny] = 1;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }

            }
            cnt++;

        }
        return cnt-1;
    }
    public static boolean checkAll(){
        for(int i =0; i<M;i++){
            for(int j =0; j<N; j++){
                if(map[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }
}