class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x=0;
        int y =0;
        
        for(int i =1; i<=yellow; i++){
            if(yellow % i ==0){
                x = i;
                y = yellow/i;
                int hap = (i+2)*2 + y*2;
                if(x>=y && hap ==brown){
                    answer [0] = x+2;
                    answer[1] =y+2;
                }
            }
        }        
        return answer;
    }

}