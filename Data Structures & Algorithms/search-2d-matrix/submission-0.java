class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0; 
        int rowLength = matrix.length, colLength = matrix[0].length;
        int right = rowLength * colLength -1;
        while(left <= right) {
            int mid = left + (right -left) /2 ; 
            int row = mid/ colLength;
            int col = mid %  colLength; 
            if(matrix[row][col] < target) {
                left = mid +1;
            } else if(matrix[row][col] > target) {
                right = mid -1;
            } else if(matrix[row][col] == target) {
                return true;
            }
        }
        return false;
    }
}
