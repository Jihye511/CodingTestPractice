import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        if(scoville[0] >=K) return answer;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i =0; i<scoville.length; i++){
            q.offer(scoville[i]);
        }
        while(q.peek()<K){
            if(q.size()<2){
                return -1;
            }
            
            int cur = q.poll();
            int next = q.poll();
            int newNum = cur +(next*2);
          
            q.offer(newNum);
            answer  ++;
        }
       
        return answer;
    }
}