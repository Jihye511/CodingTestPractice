import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static ArrayList<Integer> stack = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i =0; i<N; i++){
            String[] str = br.readLine().split(" ");
            if(str[0].equals("push")){
                stack.add(Integer.parseInt(str[1]));
            }
            else if(str[0].equals("pop") ){
                if(!stack.isEmpty()){
                    int size = stack.size();
                    int result = stack.get(size-1);
                    stack.remove(size-1);
                    sb.append(result).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }

            }else if(str[0].equals("size")){
                sb.append(stack.size()).append("\n");
            }
            else if(str[0].equals("empty")){
                if(stack.isEmpty()){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(str[0].equals("top")) {
                if (!stack.isEmpty()) {
                    int size = stack.size();
                    int result = stack.get(size - 1);
                    sb.append(result).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}