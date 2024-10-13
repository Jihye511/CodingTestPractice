import java.io.*;
import java.util.*;
class Solution {
    static int[][] result;
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = 0;
        n  = maps.length;
        m = maps[0].length;

        dfs(maps);
        if(maps[n-1][m-1] ==1){
            answer =-1;
        }else{
            answer = maps[n-1][m-1];
        }
        
        return answer;
    }
    public static void dfs(int[][] maps){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i =0; i<4; i++){
                int nx = now[0] +dx[i];
                int ny = now[1] +dy[i];
                if(isRange(nx,ny) &&maps[nx][ny] ==1){
                    maps[nx][ny] +=maps[now[0]][now[1]];
                    q.offer(new int[] {nx,ny});
                }
            }
          
        }
    }
    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<m);
    }
}