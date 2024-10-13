import java.io.*;
import java.util.*;
class Solution {
    static int num;
    static int[][] node;
    static int cnt;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public int solution(int n, int[][] computers) {
        num = n;
        node = computers;
        visited = new boolean[n];
        list = new ArrayList[n];
        for(int i =0; i<n; i++){
            list[i] = new ArrayList<>();
        }        
        for(int i =0; i<n; i++){
            for(int j =0; j<n ; j++){
                if(i !=j && node[i][j] ==1){
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        
        for(int i =0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                cnt++;
            }
        }
      
        return cnt;
    }
    public static void dfs(int now){
        visited[now] = true;
        for(int i =0; i<list[now].size(); i++){
            int next = list[now].get(i);
            if(!visited[next]){
                visited[next] =true;
                dfs(next); 
            }
        }
    
    }
}