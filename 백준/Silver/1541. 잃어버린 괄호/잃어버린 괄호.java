import java.util.*;
import java.io.*;

public class Main{
    static String input;
    static ArrayList<Integer> num = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        String[] split = input.split("-");

        //나눈 식끼리 더해줘서 저장
        for(String s : split){
            int sum =0;
            String[] split2 = s.split("\\+");
            for(String a : split2){
                sum += Integer.parseInt(a);
            }
            num.add(sum);
        }
        //첫번째 항 빼고 다 빼기
        int result = num.get(0);
        for(int i=1; i<num.size(); i++){
            result -=num.get(i);
        }
        System.out.println(result);
    }


}