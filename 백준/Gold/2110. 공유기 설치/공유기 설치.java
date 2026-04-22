import java.io.*;
import java.util.*;

public class Main {
    static int N,C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[] home = new int[N];
        for(int i =0; i<N; i++){
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);
        System.out.println(binarySearch(home));

    }
    public static int binarySearch(int[] home){
        int lo = 1;
        int hi = home[home.length-1];
        int ans=0;
        while(lo<=hi){
            int mid = (hi-lo)/2 +lo;
            if(countDistance(home,mid)>=C){
                ans = mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return ans;
    }
    public static int countDistance(int[] home, int distance){
        boolean[] v = new boolean[N];
        v[0] = true;
        int before = home[0];
        int cnt=1;
        for(int i =1; i<N; i++){
            if(home[i] -before>= distance){
                cnt++;
                before= home[i];
            }
        }
        return cnt;
    }
}