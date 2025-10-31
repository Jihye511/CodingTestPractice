import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        answer = binary(n,times);
        return answer;
    }
    //lowerbound
    public static long binary(int n, int[] times){
        long lo = 1;
        long hi = (long) n* (long)times[times.length-1];
        while(lo<hi){
            long mid = (hi-lo)/2 + lo;
            if(count(mid, times) < n){
                lo = mid+1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
    public static long count(long time, int[] times){
        long cnt =0;
        for(int i =0; i<times.length; i++){
            cnt += time/times[i];
        }
        return cnt;
    }
}