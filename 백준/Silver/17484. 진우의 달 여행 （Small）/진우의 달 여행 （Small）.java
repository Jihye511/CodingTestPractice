import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;

   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st= new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       map = new int[N][M];
       for(int i =0; i<N; i++){
           st= new StringTokenizer(br.readLine());
           for(int j =0; j<M; j++){
               map[i][j] = Integer.parseInt(st.nextToken());
           }
       }
       int min=Integer.MAX_VALUE;
       int[] dir = {-1,0,1}; // x좌표
       for(int i =0; i<M; i++){
           Queue<int[]> q = new LinkedList<>();
           q.offer(new int[] {0,i,-1,map[0][i]}); // x,y,이전 방향,연료
           while(!q.isEmpty()){
               int[] cur = q.poll();
               if(cur[0]==N-1){
                   min = Math.min(min,cur[3]);
                   continue;
               }
               for(int j=0;j<dir.length; j++){
                   if(cur[2]==j) continue; //동일한 방향으로 못 감
                   int nx = cur[0]+1;
                   int ny = cur[1]+dir[j];
                   if(ny<0 || ny>=M) continue;
                   q.offer(new int[]{nx,ny,j,cur[3]+map[nx][ny]});
               }
           }
       }
       System.out.println(min);
   }
}