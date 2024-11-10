import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i =0; i<n; i++){
            String input = br.readLine();
            for(int j =0; j<n; j++){
                map[i][j] = input.charAt(j) - '0';
            }

        }
        int count=0;
        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                if(map[i][j] !=0){
                    dfs(i,j);
                    count++;
                }
            }
        }
        Collections.sort(list);
        sb.append(count).append("\n");
        for(int n : list){
            sb.append(n).append("\n");
        }
        System.out.println(sb);

    }
    public static void dfs(int x, int y){
        int cnt=1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        map[x][y]=0;
        while(!q.isEmpty()){
            int[] current = q.poll();
            for(int i =0; i<4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                //범위 밖이면 패쓰
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                //0이면 패쓰
                if(map[nx][ny] !=0){
                    map[nx][ny] =0;
                    cnt++;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        list.add(cnt);
//        return cnt;
    }
}
