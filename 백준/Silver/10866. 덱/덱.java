import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static int result;
    static Deque<Integer> q = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while(N-->0){
            String[] str = br.readLine().split(" ");
            switch(str[0]){
                case "push_front":
                    q.addFirst(Integer.parseInt(str[1]));
                    break;
                case "push_back":
                    q.addLast(Integer.parseInt(str[1]));
                    break;
                case "pop_front":
                    if(!q.isEmpty()){
                        sb.append(q.poll()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "pop_back":
                    if(!q.isEmpty()){
                        sb.append(q.pollLast()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(q.isEmpty()){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
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
                        sb.append(q.peekLast()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);

    }

}