import java.io.*;
import java.util.*;
class Solution {
    static int[][] map;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[] result =new int[2];
    public int solution(int[][] maps) {
        map = maps;
        int answer = 0;
        answer=bfs(0,0);
        
        return answer;
    }
    public static int bfs(int y,int x){
        int n = map.length;
        int m = map[0].length;
        boolean[][] visited= new boolean[n][m];
        visited[y][x] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[] point = q.poll();
            int rx = point[1];
            int ry = point[0];
            if (ry == n - 1 && rx == m - 1) {
                return map[ry][rx];
            }
            
            for(int i =0; i<4; i++){
                int nx = rx +dx[i];
                int ny = ry +dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    map[ny][nx] = map[ry][rx] +1;
                    q.offer(new int[]{ny,nx});
                }
                
            }
        }
        return -1;
    }
    
}