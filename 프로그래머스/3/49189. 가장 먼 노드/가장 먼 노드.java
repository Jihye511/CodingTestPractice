import java.io.*;
import java.util.*;
class Solution {
    static ArrayList<Integer>[] node;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        node= new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            node[i] = new ArrayList<>();
        }
        for(int i =0; i< edge.length; i++){
            int s = edge[i][0];
            int e = edge[i][1];
            node[s].add(e);
            node[e].add(s);
        }
        //bfs
        Queue<int[]> q= new LinkedList<>();
        boolean[] v= new boolean[n+1];
        q.offer(new int[]{1,0});
        v[1] =true;
        int[] depth = new int[n+1];
        depth[1] = 0;
        int max =0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            for(int i =0; i<node[x].size(); i++){
                int next = node[x].get(i);
                if(!v[next]){
                    v[next]= true;
                    depth[next] = cur[1]+1;
                    q.offer(new int[]{next, cur[1]+1});
                    max = Math.max(max, depth[next]);
                }
            }
        }
        
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(depth[i] == max){
                count++;
            }
        }
        return count;
    }
    
}