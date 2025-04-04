
import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[][] gap;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		int[] num = new int[N];
		for(int i =0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		
		}
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for(int i =0; i<N; i++) {
			for(int j =i+1; j<N; j++) {
				if(num[j]<num[i]) {
					
					dp[j] = Math.max(dp[i]+1, dp[j]);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N-1]);

		
		
	}
}
