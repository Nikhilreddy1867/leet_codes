class Solution {
    private static void helper(int row,int[][] matrix){
        int[] arr=matrix[row];
        Arrays.fill(arr,0);
        matrix[row]=arr;
    }
    private static void helper1(int col,int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            matrix[i][col]=0;
        }
    }
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        HashSet<Integer> hs=new HashSet<>();
        HashSet<Integer> hs1=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    hs.add(i);
                    hs1.add(j);
                }
            }
        }
        for(int temp:hs){
            helper(temp,matrix);
        }
        for(int temp:hs1){
            helper1(temp,matrix);
        }
      
    }
}