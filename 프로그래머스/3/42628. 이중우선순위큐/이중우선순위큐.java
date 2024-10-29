import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((a,b)-> b-a);
        
        for(int i =0; i<operations.length; i++){
            String[] str = operations[i].split(" ");
            if(str[0].equals("I")){
                
                int num = Integer.parseInt(str[1]);
                pq.offer(num);
                pqMax.offer(num);
            }else if(operations[i].equals("D -1")){
                if(pq.isEmpty()) continue;
                int n = pq.poll();
                pqMax.remove(n);
            }else{
                if(pq.isEmpty()) continue;
                int n = pqMax.poll();
                pq.remove(n);
            }
            
        }
        if(pqMax.isEmpty()){
            answer[0] =0;
            answer[1] =0;
        }else{
            answer[0] = pqMax.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }
}