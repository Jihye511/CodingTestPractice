import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] num, com;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        M = Integer.parseInt(br.readLine());
        com = new int[M];
        st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<M; i++){
            com[i] = Integer.parseInt(st.nextToken());
            sb.append(binary(com[i])).append("\n");
        }
        System.out.println(sb);

    }
    public static int binary(int n){
        int lo =0;
        int hi =N-1;
        while(lo<=hi){
            int mid=(hi-lo)/2 + lo;
            if(num[mid] == n){
                return 1;
            }
            else if(num[mid]> n){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return 0;
    }
}