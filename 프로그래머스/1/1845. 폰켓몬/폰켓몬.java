import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hash = new HashSet<>();
        for(int i =0; i<nums.length; i++){
            hash.add(nums[i]);
        }
        if(nums.length/2 >hash.size()){
            answer = hash.size();
        }else{
            answer = nums.length/2;
        }

        return answer;
    }
}