import java.io.*;
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long lo = 0; 
        long hi = (long)times[times.length-1] * n;
        while(lo<=hi){
            long mid = (hi-lo)/2 + lo;
            if(count(times, mid)>=n){
                answer = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return answer;
    }
    public static long count(int[] times, long mid){
        long cnt=0;
        for(int t: times){
            cnt += (long)mid/t;
        }
        return cnt;
    }
}