import java.util.*;
import java.io.*;

public class Main{
    static int N,K,max=0;

    static int[] num;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num= new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num); //오름차순 정렬
        dfs(0);
        System.out.println(max);
    }
    public static void dfs(int total){
        if(total>N){
            return;
        }
        if(total>max){
            max = total;
        }
        for(int i =K-1; i>=0; i--){
            dfs(10*total + num[i]);
        }
    }

}