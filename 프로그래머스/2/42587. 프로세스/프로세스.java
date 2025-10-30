import java.io.*;
import java.util.*;

class Solution {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[1] - a[1]);
        Queue<int[]> q = new LinkedList<>();
        for(int i =0; i<priorities.length; i++){
            q.offer(new int[]{i,priorities[i]});
            pq.offer(new int[]{i, priorities[i]});
        }
        int idx =0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int[] max = pq.poll();
            if(cur[1] == max[1]){
                idx++;
                if(cur[0] == location) {
                answer = idx;
                break;
            }
            }else{
                q.offer(new int[]{cur[0], cur[1]});
                pq.offer(new int[]{max[0],max[1]});
            }
        }
        return answer;
    }
}