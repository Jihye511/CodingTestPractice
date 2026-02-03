import java.io.*;
import java.util.*;

public class Main {
    public static void  main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k =1;
        int num ;
        int last = 1;
        while(N > last){
            k++;
            num = (k-1) *6;;
            last += num;
        }
        System.out.println(k);

    }

}
