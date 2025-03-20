import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
//         Queue<int[]> pq = new PriorityQueue<>((a, b)->{
//             if(a[0]==b[0]) return a[1]-b[1];
//             else return b[0]-a[0];
//         }); 
        
        Queue<int[]> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i =0; i<priorities.length; i++){
            q.offer(new int[]{priorities[i],i});
            // pq.offer(new int[]{priorities[i],i});
            list.add(priorities[i]);
        }
        Collections.sort(list, Collections.reverseOrder());
        
        int cnt=1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == list.get(0)){
                if(cur[1] == location){
                    break;
                }
                list.remove(0);
                cnt++;
            }else {
                q.offer(new int[]{cur[0],cur[1]});
            }
            
        }
        
        
        // Collections.sort(q,)
        // int[] n = new int[priorities.length];
        // int idx=0;
        // for(int[] v: pq){
        //     n[idx] =v[1];
        //     idx++;
        // }
//         for(int i=0; i<priorities.length;i++){
//             int[] cur=pq.poll();
//             if(cur[1] == location){
//                 return i+1;
//             }
//         }
        
        return cnt;
    }
}