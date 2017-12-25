import java.util.HashMap;
import java.util.ArrayList;
/**
 * Created by kaizh on 1/1/2017.
 */
public class LongestArithmeticSubsequence {

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10};
        ArrayList<HashMap<Integer,Integer>> indexMap = new ArrayList<>(nums.length);
        for(int i = 0; i < nums.length; i++)
            indexMap.add(new HashMap<>());
        int max = 0;
        for(int i = 1; i < indexMap.size(); i++){
            for(int j = i - 1; j >=0; j--){
                int dif = nums[i] - nums[j];
                if(!indexMap.get(i).containsKey(dif))
                    indexMap.get(i).put(dif,2);
                if(indexMap.get(j).containsKey(dif))
                    indexMap.get(i).put(dif, Math.max(indexMap.get(j).get(dif) + 1, indexMap.get(i).get(dif)));
                max = Math.max(max,indexMap.get(i).get(dif));
            }
        }
        System.out.println(max);
    }
}
