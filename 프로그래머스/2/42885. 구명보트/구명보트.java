import java.io.*;
import java.util.*;
class Solution {
    static Integer[] peopleInteger;
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min=0;
        for(int max = people.length-1; max>=min; max--){
            if(people[min] + people[max] <=limit) min++;
            answer++;
        }
        return answer;
    }
 
}