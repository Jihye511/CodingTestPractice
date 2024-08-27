import java.util.*;
import java.io.*;

public class Main{
    static int A,B,C,M,piro;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B= Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int work=0;
        piro = 0;
        for(int i =0; i<24; i++){
            if((piro + A)<=M){
                piro += A;
                work+=B;
            }
            else{
                piro-= C;
                if(piro<0){
                    piro =0;
                }
            }
        }
        System.out.println(work);

    }
}