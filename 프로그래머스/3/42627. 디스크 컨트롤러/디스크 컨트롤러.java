import java.io.*;
import java.util.*;
class Pair{
    int start;
    int time;
    public Pair(int start, int time){
        this.start = start;
        this.time = time;
    }
}
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int nowTime =0; //현재 시간
        int sum=0;      //전체 대기 시간 합
        
        Arrays.sort(jobs,(a,b) -> a[0]-b[0]);
        //작업 시간 기준 오름차순 정렬
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.time - b.time);


        int jobIndex = 0; // jobs 배열 인덱스
        int count = 0; // 완료된 작업 수
        

        while(count < jobs.length){
            //하나의 작업이 완료되는 시점까지 들어온 모든 요청을 큐에 넣음
            while(jobIndex < jobs.length && jobs[jobIndex][0] <= nowTime){
                pq.offer(new Pair(jobs[jobIndex][0], jobs[jobIndex][1]));
                jobIndex ++;
            }
            
            if(!pq.isEmpty()){
                Pair cur = pq.poll();
                nowTime += cur.time;
                sum += (nowTime - cur.start);
                count++;
                
            }else{
                nowTime = jobs[jobIndex][0];
            }
                
        }
            
        
    
        answer = sum /jobs.length;
        return answer;
    }
}