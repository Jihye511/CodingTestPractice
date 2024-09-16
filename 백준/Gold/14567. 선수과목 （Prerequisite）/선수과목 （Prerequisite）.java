import java.io.*;
import java.util.*;

public class Main{
    static int N,M;
    static ArrayList<Integer> num[];
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new ArrayList[N+1];
        dp = new int[N+1];
        for(int i =0; i<=N; i++){
            num[i] = new ArrayList<>();
        }
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            num[a].add(b);
        }
        Arrays.fill(dp,1);
        for(int i =1; i<= N; i++){
            if(num[i].isEmpty()){
                continue;
            }
            for(int n : num[i]){
                dp[n] = Math.max(dp[n],dp[i]+1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =1; i<=N; i++){
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }

}