import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][]  v= new boolean[maps.length][maps[0].length];
        answer = bfs(maps, v);
        if(answer ==1) answer =-1;
        return answer;
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static int bfs(int[][] maps, boolean[][]v){
        int cnt=1;
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{0,0,1});
        v[0][0] = true;
        while(!q.isEmpty()){
            int[] cur= q.poll();
            int x = cur[0];
            int y = cur[1];
            int value = cur[2];
            for(int i =0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(v[nx][ny]) continue;
                if(maps[nx][ny] == 0) continue;
                
                if(nx == n-1 && ny ==m-1) {
                    return value+1;
                    
                }
                
                v[nx][ny] = true;
                q.offer(new int[]{nx,ny,value+1});
                
                
            }
           
        }
         return cnt;
    }
}