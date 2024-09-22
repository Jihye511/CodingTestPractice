import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    static int[] dots;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dots = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            dots[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dots);
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int start_index = bSearch(start,0);
            int end_index = bSearch(end, 1);

            sb.append(end_index - start_index).append("\n");
        }
        System.out.println(sb);
    }
    private static int bSearch(int start, int check){
        int left = 0;
        int right = N-1;
        if(check == 1){

            while(left <= right){
                int mid = (left +right)/2;
                if(dots[mid]>start){
                    right = mid -1;
                }
                else{
                    left  = mid +1;
                }
            }
            return right+1;
        }else {
            while(left <= right){
                int mid = (left +right)/2;
                if(dots[mid]<start){
                    left = mid +1;
                }
                else{
                    right  = mid -1;
                }
            }
            return left;
        }


    }
}