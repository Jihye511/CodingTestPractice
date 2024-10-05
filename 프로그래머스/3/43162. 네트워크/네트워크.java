import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int[][] map;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer =0;
        N = n;
        map = computers;
        visited = new boolean[N];
        for(int i =0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    public static void dfs(int com){
        visited[com] = true;
        for(int i =0; i<N; i++){
            if(map[com][i]==1 &&!visited[i]){
                dfs(i);
            }
        }
        
        
    }

}