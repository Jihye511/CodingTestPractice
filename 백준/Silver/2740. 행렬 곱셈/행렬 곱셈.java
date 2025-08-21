import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map1;
    static int[][] map2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map1 = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] val = new int[map1.length][map2[0].length];
        for(int i =0; i<map1.length; i++){
            for(int j =0; j<map2[0].length; j++){
                for(int k=0; k<map2.length; k++){
                    val[i][j] += map1[i][k] * map2[k][j];
                }
            }
        }
        for(int[] row : val){
            for(int v : row){
                System.out.print(v +" ");
            }
            System.out.println();
        }

    }
}
