import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static int n;
    static long [][] dp;
    static final long MOD = 1_000_000_000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp= new long[n+1][10];

        //초기값 설정(길이가 1일때 계단수의 개수만 설정해주면 됨,단, 범위 넘을 수 있기 때문에 long 배열 사용)
        for(int i=0; i<=9; i++) {
            dp[1][i] = 1L;
        }
        for(int i =2; i<=n; i++){   //길이
            //1. 길이 i, 0으로 시작
            dp[i][0] = dp[i-1][1];
            for(int j =1; j<=9; j++) { //첫숫자
                //길이 i, 9로 시작
                if(j ==9){
                    dp[i][j] = dp[i-1][8] %MOD;
                }
                //2. 길이 i, j 로 시작
                else {
                    dp[i][j] = (dp[i - 1][j - 1]%MOD + dp[i - 1][j + 1]%MOD) %MOD;
                }
            }
            dp[i][9] = dp[i-1][8];
        }
        long result = 0;
        for(int i =1; i<=9;i++ ){
            result = (result + dp[n][i]) %MOD;
        }
        System.out.println(result);
    }
}

