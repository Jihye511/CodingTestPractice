import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int sum =0;
        int max =0;
        for(int i =0; i<N; i++){
              arr[i] = Integer.parseInt(st.nextToken());
              max = Math.max(max, arr[i]);
              sum += arr[i];
        }
        System.out.println(binarySearch(arr, sum, max));
    }
    public static int binarySearch(int[] arr, int sum, int max){
        int lo = max;
        int hi = sum;
        int ans = 0;
        while(lo<=hi){
            int mid = (hi-lo)/2 + lo;
            if(countBlue(arr, mid)<= M){
                ans = mid;
                hi = mid -1;
            }else{
                lo = mid+1;
            }
        }
        return ans;
    }
    public static int countBlue(int[] arr, int mid){
        int cnt=1;
        int sum=0;
        for(int i =0; i<N; i++){
            if(sum + arr[i]<=mid){
                sum+=arr[i];
            }else{
                cnt++;
                sum=arr[i];
            }
        }
        return cnt;
    }
}