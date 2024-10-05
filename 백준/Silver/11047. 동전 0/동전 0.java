import java.io.*;
import java.util.*;
public class Main {
    static int n,k;
    static ArrayList<Integer> money;
    static int result=0;

    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());
        k =Integer.parseInt(st.nextToken());

        money = new ArrayList<>();
        for(int i =0; i<n; i++){
            int a= Integer.parseInt(br.readLine());
            money.add(a);
        }
        Collections.sort(money,Comparator.reverseOrder());
        for(int i =0; i<n; i++){
            if(k>=money.get(i)){
                result += (k/money.get(i));
                k %= money.get(i);
            }
        }
        System.out.println(result);
    }

}