import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visit;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n][m];
        map = new int[n][m];
        //공백이 없는 문자열 처리할때는 stringtokenizer 사용 못함
        String str;
        for (int i =0; i<n; i++){
            str = br.readLine();
            for(int j = 0; j<m; j++){
                map[i][j] =str.charAt(j) -'0'; //str 문자열의 j번째 문자를 가져옴
            }
        }
        visit[0][0] = true;
        bfs(0,0);
        System.out.println(map[n-1][m-1]);


    }
    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {x,y});

        while(!q.isEmpty()){
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            for(int i =0; i < 4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX<0 || nextY<0 ||nextX>=n || nextY >= m){
                    continue;
                }
                if(visit[nextX][nextY] || map[nextX][nextY] == 0){
                    continue;
                }

                q.add(new int[] {nextX,nextY});
                map[nextX][nextY] = map[nowX][nowY] +1;
                visit[nextX][nextY] =true;
            }
        }

    }
}