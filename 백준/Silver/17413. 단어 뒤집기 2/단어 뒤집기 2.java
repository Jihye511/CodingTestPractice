import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()); // st는 공백을 구분자로 문자열을 나누기때문에 첫번째 공백까지만 s에 저장, 나머지는 무시됨

        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        boolean status = true;

        for (char ch : S.toCharArray()) {
            // arr[i]가 '<' ~'>" 만날때 까지는 그대로 두기
            if (ch == '<') {
                status = false;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append("<");
            } else if (ch == '>') {
                status = true;
                sb.append(">");
            } else if (ch == ' ') {
                //공백 전까지 문자 뒤집기
                while (!stack.isEmpty())
                    sb.append(stack.pop());
                sb.append(" ");
            } else {
                if (status) { //태그 밖 문자
                    stack.push(ch);
                } else { //태크 안 문자
                    sb.append(ch);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        //arr[i]가 >이거 다음부터 공백/'<' 전까지는 뒤집기
        //arr[i]가 공백 ~ '<'/ 문자열 끝 만나기 전까지는 뒤집

        System.out.println(sb.toString());
    }
}