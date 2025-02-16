import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            q.offer(new int[] {progresses[i], speeds[i]});
        }
        ArrayList<Integer> list = new ArrayList<>();
        int before = 0;
        int before_day=0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int extra = 100- cur[0]; // 남은 퍼센트
            int days;
            if(extra %cur[1] == 0){
                days = extra /cur[1];
            }else{
                days = extra /cur[1] +1;
            }
            //앞에 days보다 작으면 묻어가기
            if(before>=days){
                before_day++;
            }else{
                list.add(before_day);
                before_day = 1;
                before = days;
            }
        }
        list.add(before_day);
        int[] answer = new int[list.size()-1];
        for(int i =1; i<list.size(); i++){
            answer[i-1] = list.get(i);
        }
        return answer;
    }
}