import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[] dp;
    static int min=0;
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[0]=0;
        dp[1]=0;
        System.out.println(simulation(2,N));
    }
    public static int simulation(int X,int N){

        while (X<=N){

            //6의배수일때
            if(X %6 ==0){
                int min1 = Math.min(dp[X/2]+1,dp[X-1]+1);
                int min2 = Math.min(dp[X/3]+1,dp[X-1]+1);
                min = Math.min(min1, min2);
            }
            else if(X%3==0){
                min= Math.min(dp[X/3]+1,dp[X-1]+1);
            }else if(X%2==0){
                min = Math.min(dp[X/2]+1,dp[X-1]+1);
            }else{
                min = dp[X-1]+1;
            }
            dp[X] = min;
            X++;
        }
        return dp[N];
    }
}
