import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new LinkedList<>();
        for(int val: prices){
            q.offer(val);
        }
        for(int i =0; i<prices.length;i++){
            int cur = q.poll();
            int count =0;
            for(int n : q){
                count++;
                if(cur>n){
                    break;
                }
            }
            answer[i] = count;
            
        }
        
        
        return answer;
    }
}