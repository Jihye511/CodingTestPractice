import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static long[] arr, sum;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N+1];
        sum = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int j=2; j<N+1; j++){
            sum[j] = Integer.MAX_VALUE;
            for(int i =1; i<j; i++){
                long max = cal(i,j,arr[i],arr[j]);
                max = Math.max(max, sum[i]); //k 최대 뽑고
                sum[j] = (int) Math.min(sum[j],max);  //그 최대 가장 작게 나오는 값을 저장
            }
        }
        System.out.println(sum[N]);
    }
    public static long cal(int i, int j, long a, long b){
        return (j-i)*(1+Math.abs(a-b));
    }
}