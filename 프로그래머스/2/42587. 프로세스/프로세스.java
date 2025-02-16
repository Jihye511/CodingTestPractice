import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
       Queue<int[]> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0; i<priorities.length; i++){
            q.offer(new int[]{priorities[i],i});
        }
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            boolean check = false;
            for(int i =0; i<q.size(); i++){
                int[] next = q.poll();
                if(cur[0] < next[0]){
                    check = true;
                }
                q.offer(new int[] {next[0], next[1]});
            }
            if(check){
                q.offer(new int[]{cur[0],cur[1]});                
            }else{
                list.add(cur[1]);
            }
            
        }
        int ans = 0;
        for(int i =0; i<list.size(); i++){
            if(list.get(i) ==location){
                ans = i+1;
            }
        }
        return ans;
    }
}