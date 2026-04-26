import java.io.*;
import java.util.*;

public class Main {
    static int N,C;
    static int[] home;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new int[N];
        for(int i =0; i<N; i++){
            home[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);
        int lo=1;
        int hi=home[N-1];
        int  ans =0;
        while(lo<=hi){
            int mid = (hi-lo)/2+lo;
            if(countHome(mid)>=C){
                ans = mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        System.out.println(ans);

    }
    public static int countHome(int mid){
        int cnt=1;
        int before = home[0];
        for(int i =1; i<home.length; i++){
            if(home[i]-before >=mid){
                cnt++;
                before =home[i];
            }
        }
        return cnt;
    }
}