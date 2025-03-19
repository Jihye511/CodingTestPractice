
import java.io.*;
import java.util.*;
public class Main {
	static int N,C;
	static int[] num;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		for(int i =0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		System.out.println(binary());
				
		

	}
	public static int binary() {
		int start = 1;
		int end = num[N-1] - num[0]+1;
		
		while(start< end) {
			int mid =(start + end)/2;
			
			if(checknum(mid)>=C) {
				start = mid +1;
			}else {
				end = mid;
			}
		}
		return start-1;
		
	}
	public static int checknum(int m) {
		
		int before = num[0];
		int cnt=1;
		for(int i =1; i<N; i++) {
			if(num[i]-before >=m) {
				cnt++;
				before = num[i];
			}
		}
		
		return cnt;
	}

}
