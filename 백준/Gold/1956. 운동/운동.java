import java.io.*;
import java.util.*;

public class Main{
    static int V,E;
    static int[][] map;
    static final int INF =4000001;
    static int[] dis;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new int[V+1][V+1];
        dis = new int[V+1];
        for(int i =0; i<V+1; i++){
            Arrays.fill(map[i],INF);
        }
        for(int i =0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());

            map[a][b] = c;
        }
        //사이클도는 최단거리 출력
        for(int i =1;i<V+1; i++){
            for(int j =1; j<V+1; j++){
                for(int k =1; k<V+1;k ++){
                    if(map[j][k] >map[j][i]+map[i][k]){
                        map[j][k] = map[j][i]+map[i][k];
                    }

                }
            }
        }
        int result =INF;
        for(int i =1; i<V+1; i++){
            result = Math.min(result, map[i][i]);
        }
        if(result ==INF){
            System.out.println(-1);
        } else{
            System.out.println(result);
        }
    }
}