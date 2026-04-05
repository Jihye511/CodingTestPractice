import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args)throws IOException {
       StringBuilder sb = new StringBuilder();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String words = br.readLine();
       int n = Integer.parseInt(br.readLine());

       Deque<Character> left = new ArrayDeque<>();
       Deque<Character> right = new ArrayDeque<>();

       for(Character c : words.toCharArray()){
           left.addLast(c);
       }
       for(int i =0; i<n; i++){
           String[] input = br.readLine().split(" ");
           if(input[0].equals("P")){
               left.addLast(input[1].charAt(0));
           }
           else if(input[0].equals("L")){
               if(!left.isEmpty()){
                   right.addFirst(left.removeLast());
               }
           }else if(input[0].equals("D")){
               if(!right.isEmpty()){
                   left.addLast(right.removeFirst());
               }
           }else if(input[0].equals("B")){
               if(!left.isEmpty()){
                   left.removeLast();
               }
           }
       }
       for(Character c : left){
           sb.append(c);
       }
       for(Character c : right){
           sb.append(c);
       }
       System.out.println(sb);
   }
}