import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []time =new int[N+1];
		int[] price= new int[N+1];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		for(int i =1; i<=N; i++) { //시작날짜
			if(time[i]> N-i+1) continue;
			dp[i] = Math.max(price[i], dp[i]);
			for(int j =i+time[i]; j<=N; j++) { //다음 날짜
				if(time[j]> N-j+1) continue;
				dp[j] = Math.max(dp[j], dp[i]+ price[j]);
			}
		}

		Arrays.sort(dp);
		System.out.println(dp[N]);
	}

}
