import java.util.*;
import java.io.*;

public class Main {
    static int n, cnt = 0;
    static int[] rome = {1, 5, 10, 50};
    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        simulate(0, 0, 0);
        System.out.println(hashSet.size());


    }

    public static void simulate(int level, int sum, int idx) {
        if (level == n) {
            hashSet.add(sum);
            return;
        }
        for (int i = idx; i < 4; i++) {
            simulate(level + 1, sum + rome[i], i);


        }
    }
}