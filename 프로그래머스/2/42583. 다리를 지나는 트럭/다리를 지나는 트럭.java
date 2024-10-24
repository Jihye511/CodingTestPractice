import java.io.*;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        //런타임에러발생
        // //비어잇는 다리 공간 모두 0으로 초기화
        // for(int i =0; i<bridge_length;i++){
        //     q.offer(0);
        // }
        
        if(bridge_length ==1) return truck_weights.length+1;
        if(truck_weights.length == 1) return bridge_length+1;
        
        int curWeight =0;
        for(int t:truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.offer(t);
                    curWeight +=t;
                    answer ++;
                    break;
                }
                else if(q.size()==bridge_length){
                    curWeight -=q.poll();
                }
                else {
                    if(curWeight +t >weight){
                        q.offer(0);
                        answer ++;
                    }
                    else{
                        q.offer(t);
                        curWeight +=t;
                        answer ++;
                        break;
                    }
                }
            }
        }
        
        return answer+bridge_length;
    }
}