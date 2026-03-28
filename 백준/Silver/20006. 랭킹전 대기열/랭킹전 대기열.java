import javax.imageio.ImageTranscoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static class Player {
        int level;
        String name;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }
   public static void main(String[] args)throws IOException {
       StringBuilder sb = new StringBuilder();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int p = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       ArrayList<List<Player>> rooms = new ArrayList<>();
       ArrayList<Integer> roomLevel = new ArrayList<>();
       for(int i =0; i<p; i++){
           st = new StringTokenizer(br.readLine());
           int l =Integer.parseInt(st.nextToken()); //레벨
           String n=st.nextToken(); //닉네임

           boolean checkInput =false;
           for(int j=0; j<roomLevel.size(); j++){
                   if(l>=roomLevel.get(j)-10 && l<=roomLevel.get(j)+10 && rooms.get(j).size()<m){
                       rooms.get(j).add(new Player(l,n));
                       checkInput = true;
                       break;
                   }
           }
           if(!checkInput){
                   //방 만들기
               List<Player> newRoom = new ArrayList<>();
               newRoom.add(new Player(l, n));
               rooms.add(newRoom);
               roomLevel.add(l);
           }
       }
        for(List<Player> room : rooms){
            if(room.size() ==m){
                sb.append("Started!").append("\n");
            }else {
                sb.append("Waiting!").append("\n");
            }
            room.sort(Comparator.comparing(player -> player.name));
            for (Player player : room) {
                sb.append(player.level).append(" ").append(player.name).append("\n");
            }
        }
       System.out.println(sb);
   }
}