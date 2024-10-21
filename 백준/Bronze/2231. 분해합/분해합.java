import java.util.*;
import java.io.*;

public class Main{
    static int sum,number,result, n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = 0;

        for(int i =0; i<n; i++){
            number = i;
            sum=0;

            while(number!= 0){
                sum += number%10;
                number/=10;
            }

            if(sum +i ==n){
                result =i;
                break;
            }
        }
        System.out.println(result);
    }
}