import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>(); //귤 종류, 개수
        for(int i : tangerine){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        //개수로 내림차순 정렬
        List<Integer> vlist = new ArrayList<>(map.values());
        vlist.sort((o1,o2) ->o2-o1);
        
        //map돌면서 가능한 최솟값 구하기
        int sum=0;
        int min =0;
        for(int v : vlist){
            if(sum+v >=k){
                min++;
                break;
            }else{
                sum+=v;
                min++;
            }
        }
        return min;
    }
}