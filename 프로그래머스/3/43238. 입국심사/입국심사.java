import java.io.*;
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        answer = binarySearch(n, times);
        return answer;
    }
    public long binarySearch(int n, int[] times){
        long start =0;
        long end = times[times.length-1] * (long)n;
        long result =0;
        while(start <= end){
            long mid = (start +end)/2;
            if(timeCheck(times, n,mid)){
                result = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return result;
    }
    public boolean timeCheck(int[] times, int n,long mid){
        long people = 0;
        for(int i =0; i<times.length; i++){
            people += mid/times[i];
        }
        //people이 n 보다 크면 true
        return people>=n;
    }
}