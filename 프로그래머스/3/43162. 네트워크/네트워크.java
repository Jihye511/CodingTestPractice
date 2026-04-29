import java.io.*;
import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
         boolean[] v = new boolean[n];
        for(int i =0; i<n; i++){
            if(!v[i]){
                bfs(v, computers, i,n);
                answer++;
            }
        }
        
        
        return answer;
    }
    public static void bfs(boolean[] v, int[][] computers, int start, int n){
       
        Queue<Integer> q= new LinkedList<>();
        v[start] = true;
        q.offer(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i =0; i< n; i++){
                if(computers[cur][i] ==1 && !v[i]){
                    v[i] = true;
                    q.offer(i);
                }
            }
        }
    }
   
}