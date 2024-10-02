import java.io.*;
import java.util.*;
class Pair{
	int x;
	int y;
	public Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}
class Main {
	static int n,cnt;
	static int [][] map;
	static Queue<Pair> q = new LinkedList();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n =Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i =0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<n; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}			
		}
		for(int i =0; i<n; i++){
			for(int j=0; j<n; j++){
				if(map[i][j] ==1){
					bfs(i,j);
					cnt++;
				}
				
			}
		}
		System.out.println(cnt);
		
	}
	public static void bfs(int x, int y){
		q.offer(new Pair(x,y));
		map[x][y] =0;
		while(!q.isEmpty()){
			Pair current = q.poll();
			x = current.x;
			y = current.y;

				for(int i =0; i<4; i++){
					int nx = x +dx[i];
					int ny = y +dy[i];
					if(nx>=0 && nx<n && ny>=0 && ny<n){
						if(map[nx][ny] ==1 ){
							q.offer(new Pair(nx,ny));
							map[nx][ny] =0;
						}
					}
				}

		}
	}
}