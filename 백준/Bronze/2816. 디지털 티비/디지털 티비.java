import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        int idx1=0, idx2=0;
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
            if (str[i].equals("KBS1")) {
                idx1 = i;
            } else if (str[i].equals("KBS2")) {
                idx2 = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx1; i++) sb.append('1'); // 내려가기
        for (int i = 0; i < idx1; i++) sb.append('4'); // 위로 올리기

        if (idx1 > idx2) idx2++;

        for (int i = 0; i < idx2; i++) sb.append('1');
        for (int i = 0; i < idx2 - 1; i++) sb.append('4');
        System.out.println(sb);
    }
}