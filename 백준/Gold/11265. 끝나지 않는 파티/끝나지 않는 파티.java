import java.io.*;
import java.util.*;

public class Main { // 끝나지 않는 파티
    static int N,M;
    static long[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());
        map =new long[N][N];

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                map[i][j]  = Long.parseLong(st.nextToken());
            }
        }
        //플로이드마샬로 최단거리 계산해서 넣어두기
        //i를 경로로
        for(int i =0;i<N; i++){
            //j부터
            for(int j =0; j<N; j++){
                //k로 이동
                for(int k =0; k<N; k++){
                    if(i != j&& j !=k&& i!= k){
                        long distance = map[j][i] +map[i][k];
                        map[j][k] = Math.min(map[j][k],distance);
                    }
                }
            }
        }
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if(map[A-1][B-1]<=C){
                sb.append("Enjoy other party");
                sb.append("\n");
            }else{
                sb.append("Stay here");
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }

}