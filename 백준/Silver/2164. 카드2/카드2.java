import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            q.offer(i);
        }
        boolean check = false;
        while(q.size() !=1){
            if(!check){
                check = true;
                q.poll();
            }else{
                check = false;
                int n = q.poll();
                q.offer(n);
            }
        }
        System.out.println(q.poll());
    }
}