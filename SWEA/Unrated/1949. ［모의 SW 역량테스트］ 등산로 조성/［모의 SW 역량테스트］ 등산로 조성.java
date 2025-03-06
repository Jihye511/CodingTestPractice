
import java.io.*;
import java.util.*;
public class Solution {
	static int N,K;
	static int[][] map;
	static int max;
	static int maxResult;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			max = 0;
			maxResult=0;
			for(int i =0; i<N; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j =0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
			for(int i =0; i<N; i++) {
				for(int j =0; j<N; j++) {
					if(map[i][j]==max) {
						boolean[][] v= new boolean[N][N];
						v [i][j] =true;
						dfs(i,j,true, 1,map,v);
					}
				}
			}
			System.out.println("#"+t + " " + maxResult);
			
		}

	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void dfs(int x, int y, boolean cut, int depth, int [][] temp,boolean[][]v) {
		maxResult = Math.max(maxResult, depth);
//		for(int i=0; i<N; i++) {
//			for(int j =0; j<N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		for(int i =0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N)continue;
			if(v[nx][ny]) continue;
			v[nx][ny] =true;
			//그냥 가능하면 가라
			if(temp[nx][ny]<temp[x][y]) dfs(nx, ny, cut, depth+1,temp,v);
			
			//불가능하면 깎을 수 있나 확인
			else {
				if(cut) {
					for(int d =1; d<=K; d++) {
						if(temp[nx][ny]-d <temp[x][y]) {
							temp[nx][ny] -= d;
							dfs(nx, ny, !cut, depth+1,temp,v);
							temp[nx][ny] += d;
						}
					}
				}
				
			}
			v[nx][ny] =false;
		}
		
	}

}
