import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static int n,K;
    static int[] num;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = new int[n];
        dp = new int[n+1][K+1];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        for(int i =1; i<=n; i++){
            for(int j=0; j<=K; j++){
                if(num[i-1]%2 ==1){ //현재 요소 홀수일 경우
                    if(j>0){
                        dp[i][j] = dp[i-1][j-1];
                    }

                }else{
                    dp[i][j] = dp[i-1][j]+1;
                }
            }
        }
        int maxLength=0;
        //dp 에서 최대 길이 찾기
        for(int i =0; i<=n; i++){
            for(int j=0; j<=K; j++){
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        System.out.println(maxLength);
    }

}