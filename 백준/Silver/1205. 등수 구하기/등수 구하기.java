import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, taesoo, P;
        N = Integer.parseInt(st.nextToken());
        if(N == 0){
            System.out.println(1);
            return;
        }
        taesoo = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        Integer[] score = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            int a =Integer.parseInt(st.nextToken());
            score[i] = a;
        }

        Arrays.sort(score,Collections.reverseOrder());
        if(N == P && score[N-1] >= taesoo){
            System.out.println(-1);
            return;
        }
        int rank =1;
        for(int i =0; i<N; i++){
            if(score[i] > taesoo)
                rank++;
        }
        if(rank > P){
            System.out.println(-1);
        }else System.out.println(rank);
    }

}