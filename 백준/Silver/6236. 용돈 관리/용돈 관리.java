import javax.imageio.ImageTranscoder;
import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static int[] money;
    static int hap;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];
        for(int i =0; i<N; i++){
            money[i] = Integer.parseInt(br.readLine());
            min = Math.max(money[i], min);
            hap+= money[i];
        }
        System.out.println(binary());

    }
    public static int binary(){
        int lo =min;
        int hi = hap;
        int ans =0;
        while(lo<=hi){
            int mid =(hi-lo)/2 + lo;
            if(countDays(mid)>M){
                lo = mid+1;
            }else{
                ans = mid;
                hi = mid-1;
            }
        }
        return ans;
    }
    public static int countDays(int value){
         int cnt =0;
         int cur= 0;
         for(int i : money){
             if(i > cur){
                 cur = value;
                 cnt++;
             }
             cur -= i;

         }
         return cnt;
    }
}