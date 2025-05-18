import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[9];
        int sum=0;
        for(int i =0; i<9; i++){
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];
        }

        Arrays.sort(num);
        int a = 0;
        int b = 0;

        for(int i =0; i<num.length-1; i++){
            for(int j =i+1; j<num.length; j++){
                if(sum -(num[j] + num[i]) ==100){
                    a =i;
                    b =j;
                }
            }
        }
        for(int i =0; i<num.length; i++){
            if(i !=a && i !=b){
                System.out.println(num[i]);
            }
        }

    }


}