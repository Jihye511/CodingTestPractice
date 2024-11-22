import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (a,b) -> {
            if(a[1]==b[1]){
                return a[0] - b[0];
            }
            return a[1]-b[1];
        });
        int index = routes[0][1];//카메라 위치 인덱스
        for(int i =1; i<routes.length;i++){
            
            if(index < routes[i][0]){
                answer ++;
                index = routes[i][1];
            }
        }
        
        return answer;
    }
} 