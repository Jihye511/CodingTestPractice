import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] sang = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            sang[i] = Integer.parseInt(st.nextToken());
        }
        M= Integer.parseInt(br.readLine());
        int[] cards = new int[M];
        Arrays.sort(sang);
        int[] ans = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<M; i++){
            cards[i] = Integer.parseInt(st.nextToken());
            ans[i] = findEnd(sang,cards[i]) - findStart(sang,cards[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i: ans){
            sb.append(i+" ");
        }
        System.out.println(sb);


    }
    public static int findStart(int[] sang,int num){
        int lo= 0;
        int hi =N-1;
        while (lo<=hi){
            int mid = (hi-lo)/2 + lo;
            if(sang[mid]>=num){
                hi = mid-1;
            }else{
                lo  =mid+1;
            }
        }
        return lo;
    }
    public static int findEnd(int[] sang, int num){
        int lo=0;
        int hi = N-1;
        while(lo<=hi){
            int mid =(hi-lo)/2 + lo;
            if(sang[mid]<= num){
                lo= mid+1;
            }else{
                hi =mid-1;
            }
        }
        return lo;
    }
}