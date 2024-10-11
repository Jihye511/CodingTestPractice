import java.io.*;
import java.util.*;
public class Main{
   static long result;
   static int N;
   static int[] num;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        char[] array = br.readLine().toCharArray();
        // 후입선출의 자료구조 Stack선언
        Stack < Double > stack = new Stack < > ();

        // 키와 값으로 구성된 Map선언
        Map < Character, Double > map = new HashMap < > ();
        // N의 개수만큼 피연산자에 대응되는 값을 설정
        char key = 'A';
        for (int i = 0; i < N; i++) {
            map.put(key, Double.parseDouble(br.readLine()));
            key++;
        }

        //array의 길이만큼 반복 수행
        for(int i =0; i<array.length; i++){
            if('A' <= array[i] && array[i]<='Z'){
                stack.push(map.get(array[i]));
            }
            else {
                double answer1 = stack.pop();
                double answer2 = stack.pop();

                switch (array[i]) {
                    case '+':
                        stack.push(answer2 + answer1);
                        break;
                    case '-':
                        stack.push(answer2 - answer1);
                        break;
                    case '*':
                        stack.push(answer2 * answer1);
                        break;
                    case '/':
                        stack.push(answer2 / answer1);
                        break;
                }
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));
    }

}