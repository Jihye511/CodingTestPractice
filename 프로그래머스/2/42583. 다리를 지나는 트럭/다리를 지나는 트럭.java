import java.io.*;
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> waiting = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        int total = 0;
        for(int i : truck_weights){
            waiting.offer(i);
            total+=i;
        }
        
        if(total <= weight){
            return bridge_length + truck_weights.length;
        }
        int hap =0;
    
            while(!waiting.isEmpty()){
                int cur = waiting.peek();
                if(bridge.size() == bridge_length){
                    int w = bridge.poll();
                    hap -= w;
                }
                //다리 아직 하나도 안올라감
                if(bridge.size()< bridge_length){
                    if(hap + cur <=weight){
                        waiting.poll();
                        bridge.offer(cur);
                        hap += cur;
                    }else{
                        bridge.offer(0);
                    }
                }
                
                answer++;
            }
            
            answer += bridge.size();
            
        
        return answer;
    }
}