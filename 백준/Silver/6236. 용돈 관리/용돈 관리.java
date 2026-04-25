import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] money = new int[N];
        long max =0;
        long sum =0;
        for(int i =0; i<N; i++){
            money[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, money[i]);
            sum += money[i];
        }
        long lo =max;
        long hi = sum;
        long ans = 0;
        while(lo<=hi){
            long mid = (hi-lo)/2 + lo;
            if(count(mid, money)<=M){
                ans = mid;
                hi=mid-1;
            }else{
                lo = mid +1;
            }
        }
        System.out.println(ans);
    }
    public static int count(long mid,int[] money){
        int cnt =0; // 인출횟수
        long today=0;
        for(int i =0; i<money.length; i++){
            if(today<money[i]){
                cnt++;
                today = mid - money[i];
            }else{
                today -= money[i];
            }
        }
        return cnt;
    }
}