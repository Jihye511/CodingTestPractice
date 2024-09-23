import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static long M;
    static int[] tree;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);
        System.out.println(bSearch());
    }
    public static int bSearch(){
        int left =0;
        int right = tree[N-1];
        int result=0;
        while(left<=right){
            int mid = (left+right)/2;
            long extra =0;
            for(int i =0; i<N; i++){
                if(tree[i]-mid>0){
                    extra += tree[i]-mid;
                }
            }
            if(extra >=M){
                result = mid;
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        return result;
    }
}