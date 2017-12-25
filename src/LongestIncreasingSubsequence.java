
/**
 * Created by kaizh on 1/4/2017.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.print(new LongestIncreasingSubsequence().maxLength(new int[] {10, 9, 2, 5, 3, 7, 101, 6}));
    }
    public  int maxLength(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int max = 0;
        int[] dp = new int[nums.length];
        for(int i = 0; i < dp.length; i ++){
            dp[i] = 1;
            for(int j = i -1; j >= 0; j--){
                if(nums[i] >= nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
