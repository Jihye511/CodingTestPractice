import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static Queue<Integer> q = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int back=0;
        for(int i =0; i<N; i++){
            String[] str = br.readLine().split(" ");
            switch(str[0]){
                case "push":
                    q.offer(Integer.parseInt(str[1]));
                    back = Integer.parseInt(str[1]);
                    break;
                case "pop":
                    if(!q.isEmpty()){
                        sb.append(q.poll()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(!q.isEmpty()){
                        sb.append(0).append("\n");
                    }else{
                        sb.append(1).append("\n");
                    }
                    break;
                case "front":
                    if(!q.isEmpty()){
                        sb.append(q.peek()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if(!q.isEmpty()){
                        sb.append(back).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}