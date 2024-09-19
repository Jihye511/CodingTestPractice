import java.io.*;
import java.util.*;

public class Main{
    static int N,M;
    static int [] sang;
    static int [] quiz;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sang = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            sang[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sang);
        M = Integer.parseInt(br.readLine());
        quiz = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(binary(num)).append(" ");
        }
        System.out.println(sb);
    }
    public static int binary(int num){
        int left = 0;
        int right = N-1;
        while (left<=right){
            int mid = (left + right)/2;
            int midValue = sang[mid];

            if(num>midValue){
                left = mid +1;
            }else if(num<midValue){
                right = mid -1;
            }else return 1;
        }
        return 0;
    }
}