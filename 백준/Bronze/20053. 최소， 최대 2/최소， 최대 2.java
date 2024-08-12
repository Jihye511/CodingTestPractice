import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        
        for (int i =0; i<T; i++){
            int N = Integer.parseInt(bf.readLine());
            int[] numbers = new int[N];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j =0; j<N; j++){
                numbers[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(numbers);
            System.out.println(numbers[0] +" "+ numbers[N-1]);

        }

    }
}
