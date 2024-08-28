import java.util.*;
import java.io.*;

public class Main{
    static int bben, degi, num,T,A,gooho,game;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        gooho = Integer.parseInt(br.readLine());
        game =1;
        while(true){
            for(int i =0; i<4; i++){
                if(i%2 ==0){
                    bben++;
                }else {
                    degi++;
                }
                if(gooho==0 && bben==T){
                    System.out.println((bben+degi-1)%A);
                    return;
                }else if(gooho==1 && degi==T){
                    System.out.println((bben+degi-1)%A);
                    return;
                }
            }

            for(int i=0; i<game+1; i++) {
                bben += 1;
                if (bben == T && gooho == 0) {
                    System.out.println((bben + degi - 1) % A);
                    return;
                }
            }
            for(int i=0; i<game+1; i++) {
                degi += 1;
                if (degi == T && gooho == 1) {
                    System.out.println((bben + degi - 1) % A);
                    return;
                }
            }
            game++;

        }

    }


}