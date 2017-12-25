/**
 * Created by Tory on 1/12/17.
 */
public class RotateMatrix {

    public static int[][] transpose(int[][] matrix){
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for(int i = 0; i < newMatrix.length; i++){
            for(int j = 0; j < newMatrix[0].length; j++){
                newMatrix[i][j] = matrix[j][i];
            }
        }
        return newMatrix;
    }
    //if flag is true,the right rotation,false is left rotation
    public static int[][] rotate(int[][] matrix,boolean flag){
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0)
            return matrix;
        int rows = matrix.length,cols = matrix[0].length;
        int[][] res = transpose(matrix);
        rows = res.length;
        cols = res[0].length;
        if(flag){
            for(int j = 0; j < cols / 2; j++){
                for(int i = 0; i < rows; i++){
                    int temp = res[i][j];
                    res[i][j] = res[i][cols - 1 - j];
                    res[i][cols - 1 - j] = temp;
                }
            }
        }
        else{
            for(int i = 0; i < rows / 2; i++){
                for(int j = 0; j < cols; j++){
                    int temp = res[i][j];
                    res[i][j] = res[rows - 1 - i][j];
                    res[rows - 1- i][j] = temp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int[][] res = rotate(matrix,true);
        for(int i = 0;i < res.length; i++){
            for(int j = 0; j < res[0].length; j++)
                System.out.printf(res[i][j] + " ");
            System.out.println();
        }
    }
}
