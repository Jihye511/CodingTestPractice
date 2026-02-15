import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t= 1; t<=T; t++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int[] line = new int[20];
            int n = Integer.parseInt(st.nextToken());
            for(int i =0; i<20; i++){
                line[i] = Integer.parseInt(st.nextToken());
            }
            int cnt=0;
            for(int i = 1; i< 20; i++){
                for(int j = i -1; j >= 0; j--){
                    if(line[i] < line[j]){
                        cnt++;
                    }
                }
            }
            sb.append(t+" ").append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}