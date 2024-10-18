import java.io.*;
import java.nio.Buffer;
import java.util.*;
public class Main {
    static int N;
    static Long M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);

        System.out.println(binarySearch(M));
    }
    public static long binarySearch(long m ){
        long start = 0;
        long end = trees[N-1];
        long result =0;
        while(start<= end){
            long mid= (start + end)/2;
            long extra = calculate(mid);
            if(extra >=m){
                result = mid;
                start = mid+1;
            }else{
                end = mid -1;
            }
        }
        return result;
    }
    public static long calculate(long m){
        long sum=0;
        for(int i =0; i<N; i++){
            if(trees[i]>m){
                sum += trees[i]-m;
            }
        }
        return sum;
    }


}