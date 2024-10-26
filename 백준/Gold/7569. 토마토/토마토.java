import java.io.*;
import java.util.*;
public class Main {
    static int M,N,H;
    static int[][][] map;
    static int[] dx ={-1,1,0,0,0,0};
    static int[] dy ={0,0,-1,1,0,0};
    static int[] dz ={0,0,0,0,-1,1};
    static Queue<int []> q= new LinkedList<>();
    static int cnt =-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        for(int i =0; i<H; i++){
            for(int j =0; j<N; j++){
                st= new StringTokenizer(br.readLine());
                for(int k =0; k<M; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if( map[i][j][k] ==1){
                        q.offer(new int[] {j,k,i});
                    }
                }
            }
        }
        bfs();
//        System.out.println(cnt);
        if(!checkZero()){
            System.out.println(cnt);
        }else{
            System.out.println(-1);
        }
    }

    public static void bfs(){
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                int[] c= q.poll();
                for(int j =0; j<6; j++){
                    int nx = c[0] +dx[j];
                    int ny = c[1] +dy[j];
                    int nz = c[2] +dz[j];
                    //범위밖이면 패쓰
                    if(nx<0 ||nx>=N ||ny<0 || ny >=M || nz <0 || nz>= H) continue;
                    //map 값이0 일때
                    if(map[nz][nx][ny] ==0){
                        map[nz][nx][ny] =1;
                        q.offer(new int[] {nx,ny,nz});
                    }
                }
            }
            cnt+=1;
        }

    }
    public static boolean checkZero(){
        for(int z=0; z<H;z++){
            for(int x =0; x<M; x++){
                for(int y =0; y<N; y++){
                    if(map[z][y][x] ==0) return true;
                }
            }
        }
        return false;
    }

}