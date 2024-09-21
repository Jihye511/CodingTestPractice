import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    static String[][] title;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        title = new String[N][2];

        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            title[i][0] = st.nextToken();
            title[i][1] = st.nextToken();
        }
        for(int i =0; i<M; i++){
            int num = Integer.parseInt(br.readLine());
            bSearch(num);
        }
        System.out.println(sb);
    }
    private static void bSearch(int n){
        int start =0;
        int end = N-1;
        while(start <=end){
            int mid =(start+end)/2;
            int titleInt = Integer.parseInt(title[mid][1]); //초기에 설정된 값
            if(titleInt <n){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        sb.append(title[start][0]).append("\n");
    }
}