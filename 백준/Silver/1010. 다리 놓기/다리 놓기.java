import java.io.*;
import java.util.*;

public class Main{
    static int t, n,m;
    static int[][]dp = new int[30][30];
    static  StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            sb.append(combi(m,n)).append("\n");
        }
        System.out.println(sb);
    }
    public static int combi(int n, int r){
        // 이미 계산해놓은 값이 있을 경우 바로 반환
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        // 2번 성질
        // n과r이 같거나 r==0 이면 1이다
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        // 1번 성질
        // nCr = n-1Cr-1 + n-1Cr 이다.
        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}