import java.io.*;
import java.util.*;
public class Main{
    static int n;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();
    static int[] input;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        input = new int[n];
        for(int i =0;i<n; i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        int now =0;
        for(int i =0;i<n; i++){
            if(now <input[i]) {
                for (int j = now + 1; j <= input[i]; j++) {
                    stack.add(j);
                    sb.append("+").append("\n");
                    now = j;
                }
            }
            // 스택의 top과 input[i]가 다르면 불가능한 경우
            if (stack.isEmpty() || stack.peek() != input[i]) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}