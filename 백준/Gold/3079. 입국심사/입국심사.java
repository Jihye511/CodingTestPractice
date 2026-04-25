import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] time;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        time = new int[N];
        long max = 0;
        for(int i =0; i<N; i++){
            time[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, time[i]);
        }
        //소요시간으로 이탐
        long lo =1;
        long hi = max*M;
        while (lo<hi){
            long mid = (hi-lo)/2 + lo;
            if(countPeople(mid)>=M){
                hi = mid;
            }else {
                lo = mid+1;
            }
        }
        System.out.println(hi);

    }
    public static long countPeople(long mid){
        long cnt =0;
        for(int i =0; i<time.length; i++){
            cnt+= mid/time[i];
            if(cnt>=M) return  cnt;
        }
        return cnt;
    }
}