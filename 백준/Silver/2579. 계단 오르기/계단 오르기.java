import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[] score;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        score = new int[n+1];
        dp = new int[n+1];
        score[0] = 0;
        for(int i =1; i<=n; i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        simulation(n);
        System.out.println(dp[n]);
    }
    public static int simulation(int idx){
        if(idx==1){
            dp[1] = score[1];
        }
        else if(idx == 2){
            dp[2] = score[1] + score[2];
        }else{
            dp[1] = score[1];
            dp[2] = score[2]+score[1];
            dp[3] = Math.max(score[1]+score[3], score[2] + score[3]);
            for(int i =4; i<=n; i++){
                dp[i] = Math.max(dp[i-3] + score[i-1] + score[i], dp[i-2] + score[i]);
            }
        }
        return dp[n];
    }
}