import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static long[] num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        num=  new long[K];
        long max = 0;
        for(int i =0; i<K; i++){
            num[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, num[i]);
        }
        if(N==1){
            System.out.println(num[0]);
            return;
        }
        long lo =1;
        long hi = max;
        long ans=0;
        while(lo<=hi){
            long mid = (hi-lo)/2 + lo;
            if(cut(mid)>=N){
                ans =mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        System.out.println(ans);
    }
    public static long cut(long mid){
        long cnt=0;
        for(long i : num){
            cnt+=i/mid;
            if(cnt>=N) return cnt;
        }
        return cnt;
    }
}