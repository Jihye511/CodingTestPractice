import java.io.*;
import java.util.*;
public class Main {
    static int N,C;
    static int[] home;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        C =Integer.parseInt(st.nextToken());
        home = new int[N];
        for(int i =0; i<N; i++){
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);
        System.out.println(binary());
    }
    public static int binary(){
        int ans = 0;
        int lo = 0;
        int hi = home[N-1] - home[0]+1;
        while(lo<hi){
            int mid = (hi-lo)/2 + lo;
            if(countHome(mid)<C){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        return lo-1;
    }
    public static int countHome(int dist){
        int cnt=1;
        int h = 0;
        for(int i=1; i<home.length; i++ ){
            if (home[i] - home[h] >= dist) {
                cnt++;
                h = i;
            }
        }
        return cnt;
    }
}
