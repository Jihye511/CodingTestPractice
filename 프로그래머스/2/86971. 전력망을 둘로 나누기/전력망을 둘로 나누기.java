import java.io.*;
import java.util.*;
class Solution {
    
    static ArrayList<Integer>[] node;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        node = new ArrayList[n+1];
        for(int i =0; i<=n; i++){
            node[i] = new ArrayList<>();
        }
        for(int i =0; i<wires.length; i ++){
            int a = wires[i][0];
            int b = wires[i][1];
            node[a].add(b);
            node[b].add(a);
        }
        //완탐 
        int min=Integer.MAX_VALUE;
        for(int[] now : wires){
            int a = now[0];
            int b = now[1];
            
            node[a].remove((Integer)b);
            node[b].remove((Integer)a);
            
            visited = new boolean[n+1];
            int count = dfs(a);
            
            int count_B = n - count;
            
            min = Math.min(min, Math.abs(count - count_B));
            node[a].add(b);
            node[b].add(a);
        }
        answer = min;
        
        return answer;
    }
    public static int dfs(int n){
        visited[n] = true;
        int cnt = 1;
        for(int next : node[n]){
            if(!visited[next]){
                cnt += dfs(next);
            }
        }
        return cnt;
    }
}