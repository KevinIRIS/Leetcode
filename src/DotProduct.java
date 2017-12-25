/**
 * Created by kaizh on 1/3/2017.
 */
public class DotProduct {
    public int dotProduct(int[][] A, int[][] B){
        int sum = 0;
        for(int[] pair : A){
            int indexA = pair[0];
            int indexB = binarySearch(B, indexA);
            sum += indexB < 0 ? 0 : pair[1] * B[indexB][1];
        }
        return sum;
    }
    public int binarySearch(int [][] B, int indexA){
        int left = 0, right = B.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(B[mid][0] == indexA)
                return mid;
            else if (B[mid][0] < indexA){
                left = mid + 1;
            }else
                right = mid;
        }
        return B[left][0] == indexA ? left : -1;
    }
}
