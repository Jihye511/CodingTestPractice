import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N,M;
    static int[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        tree =new int[N];
        for(int i =0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);
        System.out.println(upperbound());
    }
    public static long cutTree(long size){
        long extra =0;
        for(int t : tree){
            if(t<=size) continue;
            extra += (t-size);
        }
        return extra;
    }
    public static long upperbound(){
        long lo = 0;
        long hi = tree[N-1];
        long answer=0;
        while(lo<=hi){
            long mid = lo +(hi-lo)/2;
            if(cutTree(mid) >=M){
                answer = mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return answer;
    }
}