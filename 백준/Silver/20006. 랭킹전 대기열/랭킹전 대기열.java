import java.io.*;
import java.util.*;

public class Main {
    public static class Room{
        int idx;
        int level;
        public Room(int idx, int level){
            this.idx = idx;
            this.level =level;
        }
    }
   public static void main(String[] args)throws IOException {
       StringBuilder sb = new StringBuilder();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       StringTokenizer st= new StringTokenizer(br.readLine());
       int p =Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       ArrayList<Room> rooms = new ArrayList<>(); //현재 존재하는 방
       ArrayList<ArrayList<String[]>> member = new ArrayList<>(); //방에 포함된 멤버 정보

       for(int i =0; i<p; i++){
           st = new StringTokenizer(br.readLine());
           int level = Integer.parseInt(st.nextToken());
           String id = st.nextToken();

            if(rooms.isEmpty()){
                rooms.add(new Room(0,level));
                ArrayList<String[]> newRoom = new ArrayList<>();
                newRoom.add(new String[]{Integer.toString(level), id});
                member.add(newRoom);
            }
            else {
                //기존 방 레벨 비교해서 +-10이면 그 방에 넣기
                boolean addCheck = false;
                for(Room temp : rooms){
                    if(Math.abs(temp.level - level) <=10 && member.get(temp.idx).size()<m){
                        member.get(temp.idx).add(new String[]{Integer.toString(level),id});
                        addCheck =true;
                        break;
                    }
                }
                if(!addCheck){
                    ArrayList<String[]> newRoom = new ArrayList<>();
                    newRoom.add(new String[]{Integer.toString(level), id});
                    member.add(newRoom);
                    rooms.add(new Room(rooms.size(),level));
                }
            }
       }

       for(ArrayList<String[]> list : member){
           list.sort((a,b)-> a[1].compareTo(b[1]));
           if(list.size()==m){
               sb.append("Started!").append("\n");
               for(String[] player : list){
                   sb.append(player[0] +" "+ player[1]).append("\n");
               }
           }else{
               sb.append("Waiting!").append("\n");
               for(String[] player : list){
                   sb.append(player[0] +" "+ player[1]).append("\n");
               }
           }
       }
       System.out.println(sb);
   }
}