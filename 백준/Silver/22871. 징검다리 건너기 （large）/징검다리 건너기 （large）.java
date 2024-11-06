import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static int n;
    static int[] rock;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        rock = new int[n+1];
        dp = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=n; i++){
            rock[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for(int i =1; i<n; i++){
            for(int j =i+1; j<=n;j++){
                long power = getPower(i,j);
                dp[j] = Math.min(dp[j],Math.max(dp[i], power));
            }

        }
        System.out.println(dp[n]);
    }
    public static long getPower(int i, int j){
        return (long)(j-i) * (1+ Math.abs(rock[i]-rock[j]));
    }


}