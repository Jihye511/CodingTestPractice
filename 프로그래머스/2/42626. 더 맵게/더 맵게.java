import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        while(pq.size()>1){
            int a = pq.poll();
            if(a>=K) break;
            
            int b= pq.poll();
            pq.offer(a+b*2);
            answer++;
            
        }
        if(pq.peek()<K){
            answer =-1;
        }
        
        return answer;
    }
}