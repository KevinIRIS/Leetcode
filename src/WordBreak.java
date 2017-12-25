import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kaizh on 1/3/2017.
 */
public class WordBreak {
    public int wordBreak(String s, Set<String> wordDict){
        if(null == s || s.length() == 0|| null == wordDict)
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++){
            for(int j = i - 1; j >= 0; j --){
                if(dp[j] != 0 && wordDict.contains(s.substring(j,i)))
                    dp[i] += dp[j];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak test = new WordBreak();
        String s = "dogstant";
        HashSet<String> set = new HashSet<>();
        set.add("dogs");
        set.add("dog");
        set.add("stant");
        set.add("tant");
        System.out.print(test.wordBreak(s,set));
    }
}
