import java.io.*;
import java.util.*;
public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      Stack<String> stack = new Stack<>();
      int result=0;
      String[] str = br.readLine().split("");
      for(int i =0; i<str.length; i++){
         if(str[i].equals("(")){
            stack.push("(");
         }
         else if(str[i].equals(")")) {
            stack.pop();
            if (str[i - 1].equals("(")) {
               result += stack.size();

            } else {
               result++;
            }
         }
      }
      System.out.println(result);
   }
}