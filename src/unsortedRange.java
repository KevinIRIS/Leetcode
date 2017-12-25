import java.util.Arrays;
import java.util.Collections;

/**
 * Created by kaizh on 12/13/2016.
 */
public class unsortedRange {

   // private static int max = 0;

//    public static void main(String[] args) {
//        //int[] x = {10, 12, 20, 30, 9, 40, 32, 31, 35, 50, 60};
//        int[] x = {1,1,1};
//        int[] y = Arrays.copyOf(x,x.length);
//        Arrays.sort(y);
//        int firstWrong = -1;
//        for(int i = 0; i < x.length; i++){
//            if(x[i] != y[i]) {
//                firstWrong = i;
//                break;
//            }
//        }
//        if(firstWrong == -1)
//            return;
//        int lastWrong = -1;
//        for(int i = x.length - 1; i >= 0; i--){
//            if(x[i] != y[i]) {
//                lastWrong = i;
//                break;
//            }
//        }
//        System.out.print(lastWrong - firstWrong + 1);
//    }

//    public static void main(String[] args) {
//        int[] input = {1,2,3,4};
//        if(input == null || input.length != 4)
//            return ;
//        boolean[] visited = new boolean[4];
//        backtracking(input,visited,0,"");
//        System.out.print(max);
//        Arrays.sort(input);
//        String res = "";
//        boolean[] used = new boolean[4];
//        for(int i = 0; i < 4; i ++){
//            for(int j = input.length - 1; j >= 0; j--){
//                if(i == 0 && input[j] <= 2 && input[j]>=0 && !used[j]) {
//                    res += input[j];
//                    used[j] = true;
//                    break;
//                }
//                return null;
//            }
//        }
//    }
//   static void backtracking(int[] nums,boolean[] visited,int count,String s){
//        if(count == 4){
//            int hours = Integer.valueOf(s.substring(0,2)),minutes = Integer.valueOf(s.substring(2));
//            if(hours <= 24 && minutes <= 59)
//                max = Math.max(hours * 100 + minutes,max);
//            return ;
//        }
//        for(int i = 0; i < nums.length; i++){
//            if(!visited[i]){
//                visited[i] = true;
//                backtracking(nums,visited,count + 1,s + nums[i]);
//                visited[i] = false;
//            }
//        }
//    }
public static void main(String[] args) {
        String res = "";
        int[] input = {1,0,2,4};
        Arrays.sort(input);
        boolean[] used = new boolean[4];
        boolean set;
        for(int i = 0; i < 4; i ++){
            set = false;
            if(i == 0) {
                for(int j = input.length - 1; j >= 0; j--){
                    if(input[j] <= 2 && input[j]>=0 && !used[j]) {
                        set = true;
                        res += input[j];
                        used[j] = true;
                        break;
                    }
                }
            }else if(i == 1) {
                if(res.charAt(0) == '0' || res.charAt(0) == '1') {
                    for(int j = input.length - 1; j >= 0; j--){
                        if(input[j] <= 9 && input[j]>=0 && !used[j]) {
                            res += input[j];
                            used[j] = true;
                            set =true;
                            break;
                        }
                    }
                }else {
                    for(int j = input.length - 1; j >= 0; j--){
                        if(input[j] <= 4 && input[j]>=0 && !used[j]) {
                            res += input[j];
                            set = true;
                            used[j] = true;
                            break;
                        }
                    }
                }
            }else if(i == 2) {
                for(int j = input.length - 1; j >= 0; j--){
                    if(input[j] <= 5 && input[j]>=0 && !used[j]) {
                        res += input[j];
                        set = true;
                        used[j] = true;
                        break;
                    }
                }
            }else {
                for(int j = input.length - 1; j >= 0; j--){
                    if(input[j] <= 9 && input[j]>=0 && !used[j]) {
                        res += input[j];
                        set = true;
                        used[j] = true;
                        break;
                    }
                }
            }
            if(!set)
                return;
        }
        System.out.print(res);
    }
}
