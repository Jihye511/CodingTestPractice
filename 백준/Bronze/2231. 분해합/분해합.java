import java.io.*;
import java.util.*;
public class Main{
    static int n;

    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(br.readLine());
        int result=0;
        for(int i=1; i<=n;i++){
            int number=i;
            int sum=0;

            while(number>0){
                sum += number%10;

                number /=10;
            }
            if(sum +i == n){
                result =i;
                break;
            }

        }
        System.out.println(result);

    }
}