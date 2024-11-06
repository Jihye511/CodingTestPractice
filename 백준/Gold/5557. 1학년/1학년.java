import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static int n;
    static int[] sum;
    static long [][] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dp = new long[n][21];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp [0][arr[0]] =1;
        for(int i =1; i<n; i++){
            int num =arr[i];
            for(int j =0; j<=20;j++){
                if (dp[i - 1][j] > 0) {
                    // 덧셈의 경우
                    if (j + num <= 20) {
                        dp[i][j + num] += dp[i - 1][j];
                    }
                    // 뺄셈의 경우
                    if (j - num >= 0) {
                        dp[i][j - num] += dp[i - 1][j];
                    }
                }
            }

        }
        System.out.println(dp[n-2][arr[n-1]]);

    }


}