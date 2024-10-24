import java.io.*;
import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        long start = 0;
        long end = n;
        while(start<=end){
            long mid = (start+end)/2;
            if((long)Math.pow(mid,2) ==n) {
                answer = (long)Math.pow(mid+1,2);
                break;
            }
            if((long)Math.pow(mid,2) <n){
                start = mid+1;
            }else{
                end=mid-1;
            }
        }
        if(answer ==0) answer =-1;
        return answer;
    }
}