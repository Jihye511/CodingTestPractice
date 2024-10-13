import java.io.*;
import java.util.*;
class Bomb{
    int paper;
    int index;
    public Bomb(int index,int paper){
        this.index = index;
        this.paper= paper;
    }
}
public class Main{
    static int N;
    static Deque<Bomb> dq = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            dq.add(new Bomb(i+1,a));
        }

        while(!dq.isEmpty()){
           sb.append(dq.getFirst().index).append(" ");
           int next = dq.poll().paper;

           if(dq.isEmpty()) break;
           if(next>0) {
               for(int i =0; i<next-1; i++){
                   dq.addLast(dq.pollFirst());
               }
           }
           else{
               for(int i =0; i< Math.abs(next) ; i++){
                   dq.addFirst(dq.pollLast());
               }
           }
        }
        System.out.println(sb);
    }

}