import java.util.*;
import java.io.*;
class Pair{
    int loc;
    int num;
    public Pair(int loc, int num){
        this.loc =loc;
        this.num =num;
    }
}
public class Main {
    static int N;
    static Pair[] town;
    static long[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        town = new Pair[N];
        sum = new long[N];
        for(int i =0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int loc =Integer.parseInt(st.nextToken());
            int num =Integer.parseInt(st.nextToken());
            town[i] = new Pair(loc,num);
        }
        Arrays.sort(town, (a,b)->a.loc - b.loc);
        //누적합
        sum[0] = town[0].num;
        for(int i =1; i<N;i++){
            sum[i] = sum[i-1] +town[i].num;
        }
        int left =0;
        int right = N-1;
        long dist = Long.MAX_VALUE;
        while(left<= right){
            int mid = (right+left)/2;

            if(sum[mid] >= sum[N-1] - sum[mid]){
                right = mid-1;
                dist = Math.min(dist,town[mid].loc);
            }else{
                left =mid+1;
            }
        }
        System.out.println(dist);
    }
}
