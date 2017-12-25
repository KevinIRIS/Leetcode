import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaizh on 1/4/2017.
 */
public class ExpressionAddOperation {
    public int  addOperators(String num, int target) {
        if(num == null || num.length() == 0)
            return 0;
        int[] res = new int [1];
        backTracking(num,res,target, 0, 0);
        return res[0];
    }

    void backTracking(String num, int[] res, int target, long cur, int index){
        if(index == num.length()){
            if(cur == target)
                res[0]++;
            return ;
        }
        for(int i = index; i < num.length(); i++){
            if(num.charAt(index) == '0' && i != index)
                return;
            long temp = Long.valueOf(num.substring(index, i + 1));
            if(index == 0 && num.charAt(index) == '0'){
                backTracking(num,res,target,cur + temp,i + 1);
            }else{
                backTracking(num,res,target,cur - temp,i + 1);

                backTracking(num,res,target,cur + temp, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        String num  = "01";

        int res= new ExpressionAddOperation().addOperators(num,1);
        System.out.print(res);
    }
}
