
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    static boolean flag = false;
     static class Point implements Comparable<Point>{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o){
            if(this.y == o.y)
                flag = true;
            return this.y - o.y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Point> queue = new PriorityQueue<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            queue.offer(new Point(i, x - y));
            queue.offer(new Point(i, x + y));
        }
        if(flag) {
            System.out.println("NO");
            System.exit(0);
        }
        while (!queue.isEmpty()) {
            if (stack.isEmpty()) {
                stack.push(queue.poll().x);
            }
            else{
                int t = queue.poll().x;
                if(stack.peek() == t)
                    stack.pop();
                else
                    stack.push(t);
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        }else
            System.out.println("NO");
    }
}