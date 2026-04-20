import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        if(nums.length/2 <= set.size()) answer = nums.length/2;
        else{
            answer = set.size();
        }
        return answer;
    }
}