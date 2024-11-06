import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static int n;
    static int[] num;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[100001];
        dp = new int[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int max=0;
        for(int i=0;i<n; i++){
            dp[i] =num[i];
            for(int j =0; j<i; j++){
                if(num[i]> num[j]){
                    dp[i] = Math.max(dp[i], dp[j]+num[i]);
                }

            }
            max = Math.max(dp[i],max);
        }
        System.out.println(max);


    }
}