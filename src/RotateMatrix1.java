/**
 * Created by kaizh on 1/18/2017.
 */
public class RotateMatrix1 {
    public int[][]  rotate(int[][] matrix){
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0)
            return matrix;
        int rLen = matrix.length, cLen = matrix[0].length;
        int[][] res = new int[cLen][rLen];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                res[j][i] = matrix[i][j];
            }
        }
        // right
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length / 2;j++){
                int temp = res[i][j];
                res[i][j] = res[i][res[0].length - j - 1];
                res[i][res[0].length - j - 1] = temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int[][] res = new RotateMatrix1().rotate(matrix);
        for(int i = 0;i < res.length; i++){
            for(int j = 0; j < res[0].length; j++)
                System.out.printf(res[i][j] + " ");
            System.out.println();
        }
    }
}
