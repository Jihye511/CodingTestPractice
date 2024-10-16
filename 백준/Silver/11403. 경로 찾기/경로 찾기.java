import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] =Integer.parseInt(st.nextToken());
            }
        }
        for(int i =0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(map[j][i]==1 && map[i][k]==1){
                        map[j][k]=1;
                    }
                }
            }
        }
        for(int i =0;i<N; i++){
            for(int j =0; j<N; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}