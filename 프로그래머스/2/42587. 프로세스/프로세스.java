import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q= new ArrayDeque<>();
        for(int i =0; i<priorities.length; i++){
            q.offer(new int[]{i, priorities[i]});
        }
       ArrayList<Integer> idx = new ArrayList<>();
        
        //원소 빼기 실행
        while(!q.isEmpty()){
            int[] cur = q.poll();
            //cur값과 q안 원소값 비교 
            boolean check=false;
            for(int[] next:q){
                if(cur[1] < next[1]){
                    check =true;// cur 값 다시 집어넣어야함
                    break;
                }
            }
            if(check){
                q.offer(new int[]{ cur[0],cur[1]});
            }else{
                idx.add(cur[0]);
            }
        }
        //idx값 location 값 비교 ㅎㅐ서 그 인덱스 찾기
        for(int i =0; i<idx.size(); i++){
            if(idx.get(i) == location) answer = i+1;
        }
        return answer;
    }
}