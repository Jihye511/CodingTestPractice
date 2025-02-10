
import java.io.*;
import java.util.*;
class Node{
    int x;
    int y;
    int dir;
    public Node(int x, int y, int dir){
        this.x = x;
        this.y = y;
        this.dir = dir;

    }
}
public class Main {
    static int N;
    static int[][] map;
    static int[] dx ={0,1,1};
    static int[] dy = {1,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        StringTokenizer st;
        for(int i =1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(map[N][N]==1){
            System.out.println(0);
            return;
        }
        System.out.println(bfs(1,2,0));


    }
    public static int bfs(int x, int y, int dir){
        int cnt=0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y,dir));
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.x ==N && cur.y ==N) {
                cnt+=1;
                continue;
            }
            for (int i = 0; i < 3; i++) {
                // 가로(0)일 때 세로(2) 이동 불가, 세로(2)일 때 가로(0) 이동 불가
                if ((cur.dir == 0 && i == 2) || (cur.dir == 2 && i == 0)) continue;

                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!isValid(nx, ny, i)) continue; // 이동 가능한지 확인

                q.offer(new Node(nx, ny, i));
            }

//            int nx;
//            int ny;
//            //현재 상태 가로,세로,대각선인지 확인
//            if(cur.startX == cur.endX){
//                //가로 - 2가지
//                for(int i=0; i<2; i++){ // 뒷부분 좌표만 범위밖인지 벽이랑 만나는지 검사하면 될듯
//                    nx = cur.endX + dx[i];
//                    ny = cur.endY + dy[i];
//                    if(nx<1 ||nx>N || ny< 1 || ny>N) continue;
//                    if(map[nx][ny] ==1) continue;
//
//                    if(i ==1 && (map[nx-1][ny] ==1 || map[nx][ny-1] ==1)) continue;
//                    q.offer(new Node(cur.endX,cur.endY, nx,ny));
//                    if(nx == N && ny ==N)cnt+=1;
//                }
//
//            }else if(cur.startY == cur.endY){
//                //세로 - 2가지
//                for(int i=1; i<3; i++){ // 뒷부분 좌표만 범위밖인지 벽이랑 만나는지 검사하면 될듯
//                    nx = cur.endX + dx[i];
//                    ny = cur.endY + dy[i];
//                    if(nx<1 ||nx>N || ny< 1 || ny>N) continue;
//                    if(map[nx][ny] ==1) continue;
//                    if(i ==1 && (map[nx-1][ny] ==1 || map[nx][ny-1] ==1)) continue;
//                    q.offer(new Node(cur.endX,cur.endY, nx,ny));
//                    if(nx == N && ny ==N)cnt+=1;
//                }
//            }else{  //대각선 - 3가지
//                for(int i=0; i<3; i++){ // 뒷부분 좌표만 범위밖인지 벽이랑 만나는지 검사하면 될듯
//                    nx = cur.endX + dx[i];
//                    ny = cur.endY + dy[i];
//                    if(nx<1 ||nx>N || ny< 1 || ny>N) continue;
//                    if(map[nx][ny] ==1) continue;
//                    if(i ==1 && (map[nx-1][ny] ==1 || map[nx][ny-1] ==1)) continue;
//                    q.offer(new Node(cur.endX,cur.endY, nx,ny));
//                    if(nx == N && ny ==N)cnt+=1;
//                }
//
//            }

        }
        return cnt;
    }
    public static boolean isValid(int x, int y, int dir) {
        if (x > N || y > N) return false;
        if (map[x][y] == 1) return false;

        // 대각선 이동 시 추가 검사 (대각선 이동은 벽이 세 칸 다 뚫려 있어야 함)
        if (dir == 1) {
            if(x-1<1 || y-1< 1) return false;
            if (map[x - 1][y] == 1 || map[x][y - 1] == 1) return false;
        }

        return true;
    }


}