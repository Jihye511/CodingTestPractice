
import java.io.*;
import java.util.*;
public class Solution {
	static int length, start;
	static ArrayList<Integer>[] list;
	static boolean[] v;
	static int max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =10;
		for(int t =1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			length = Integer.parseInt(st.nextToken());
			start =Integer.parseInt(st.nextToken());
			
			list = new ArrayList[101];
			v = new boolean[101];
			for(int i =0; i<101; i++) {
				list[i] = new ArrayList<>();
			}
			st =new StringTokenizer(br.readLine());
			for(int i =0; i<length/2; i++) {
				int a= Integer.parseInt(st.nextToken());
				int b =Integer.parseInt(st.nextToken());
				
				list[a].add(b);
			}
			
			bfs(start);
			System.out.println("#" +t +" "+ max);
		}

	}
	public static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		v[s] =true;
		while(!q.isEmpty()) {
			int size = q.size();
			max=Integer.MIN_VALUE;
			for(int j = 0; j<size;j++) {
				int cur = q.poll();
				max = Math.max(max, cur);
				for(int i =0; i<list[cur].size(); i++) {
					int next = list[cur].get(i);
					if(!v[next]) {
						v[next] = true;
						q.offer(next);
					}
				}
			}
			
		}
	}

}
