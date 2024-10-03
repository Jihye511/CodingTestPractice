import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] input;
    static int n,cnt;
    static Integer[] dp;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        input= new int[n];
        dp = new Integer[n];
        st= new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        simulation(n);

        int max =-1;
        //길이탐색
        for(int i =0; i<n; i++){
            max = Math.max(dp[i],max);
        }
        System.out.println(max);
    }
    public static void simulation(int N) {
        for(int i =0; i<N;i++){
            dp[i] =1;

            for(int j =0; j<i; j++){
                if(input[j]<input[i] && dp[i] < dp[j]+1){
                    dp[i] =dp[j]+1;
                }
            }
        }
    }
}