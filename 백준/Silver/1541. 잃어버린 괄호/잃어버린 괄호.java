import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] val = str.split("-");
        ArrayList<Integer> list= new ArrayList<>();
        for(String s:val){
            String[] n = s.split("\\+");
            int sum =0;
            for(String i : n){
                int num = Integer.parseInt(i);
                sum +=num;
            }
            list.add(sum);
        }
        int ans=list.get(0);
        for(int i =1; i<list.size(); i++){
            ans -= list.get(i);
        }
        System.out.println(ans);
    }
}