import java.io.*;
import java.util.*;
public class Main {
	static int N, r,c;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		//열 범위 리턴 해오기
		int[] row = rowrange(r);
		
		//행 범위 리턴 해오기
		int[] col = colrange(c);
		
		int first = row[2] + col[2];


		int idx=0;
		loop:
		for(int i=row[0]; i<row[1]; i++) {
			for(int j =col[0]; j<col[1]; j++) {
			
				if(i == r && j ==c) {
					break loop;
				}
				idx++;
			}
		}
		System.out.println(first + idx);
	}
	
	//col
	public static int[] colrange(int p) { // 2x2로 만들기
		int start = 0;
		int gap = (int)Math.pow(2, N);
		int end = (int) Math.pow(2, N);
		int num=0;
		while(true) {
			
			if((end - start) ==2) return  new int[]{start, end, num};
			
			int mid = (end +start)/2;
			
			
			if(mid <= p) {
				start = mid;
				
				num += (int)Math.pow(gap/2, 2);
				
			}
			else {
				end = mid+1;
				
			}
			gap = gap/2;
			
		}
	}
	//row
	public static int[] rowrange(int p) { // 2x2로 만들기
		int start = 0;
		int gap = (int)Math.pow(2, N);
		int end = (int) Math.pow(2, N);
		int num=0;
		while(true) {
			if((end - start) ==2) return  new int[]{start, end, num};
			
			int mid = (end +start)/2;
			
			if(mid <= p) {
				start = mid;
				
				num += (int)Math.pow(gap,2)/2;
				
			}
			else {
				end = mid+1;
				
			}
			gap = gap/2;
		}
	}

}
