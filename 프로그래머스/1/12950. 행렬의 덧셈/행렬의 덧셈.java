class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int width = arr1.length;
        int height = arr1[0].length;
        int[][] answer = new int[width][height];
        for(int i =0; i<width; i++){
            for(int j = 0; j<height; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];            }
        }
        
        return answer;
    }
}