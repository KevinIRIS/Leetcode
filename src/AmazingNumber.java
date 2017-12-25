/**
 * Created by kaizh on 1/4/2017.
 */
public class AmazingNumber {
    public int findMostAmazion(int[] nums){
        if(nums == null)
            return 0;
        int[] shifts = new int[nums.length];
        int n = nums.length;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] >= n && nums[i] < 0)
                continue;
            shifts[(i + 1) % n]++;
            shifts[(i - nums[i] + 1 + n) % n] --;
        }
        int max = Integer.MIN_VALUE, index = 0, sum = 0;
        for(int i = 0; i < shifts.length; i++){
            sum += shifts[i];
            if(sum > max){
                max = sum;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.print(new AmazingNumber().findMostAmazion(new int[] {4, 2, 8, 2, 4, 5, 3}));
    }
}
