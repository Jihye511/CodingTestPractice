import java.io.*;
import java.util.*;

public class Main{
    static int n,m;
    static int[][] map;
    static final int INF = 10000001;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n =Integer.parseInt(br.readLine());
        m =Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], INF);
            map[i][i]=0;
        }

        for(int i =0; i<m; i++){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            map[a][b] =Math.min(c,map[a][b]);
        }
        //프로이드워샬
        for(int i =1; i<n+1; i++){
            for(int j =1; j<n+1;j++){
                for(int k =1;k<n+1; k++){
                    if(map[j][k]>map[j][i] +map[i][k]){
                        map[j][k] = map[j][i] +map[i][k];
                    }
                }
            }
        }

        for(int i =1; i<n+1; i++){
            for(int j =1; j<n+1; j++){
                if(map[i][j] ==INF){
                    map[i][j]=0;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}