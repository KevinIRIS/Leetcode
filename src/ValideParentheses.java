import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by kaizh on 12/12/2016.
 */
public class ValideParentheses {
    public static void main(String[] args) {
        System.out.print(maxParentheses("((xxx)()))"));
    }
    static String maxParentheses (String input){
        if(input == null)
            return null;
        int count = 0;
        StringBuilder buf = new StringBuilder(input);
        for(int i = 0; i < buf.length() ; i++){
            if(buf.charAt(i) == '(')
                count++;
            else if(buf.charAt(i) ==')'){
                if(count > 0){
                    count--;
                }else{
                    buf.deleteCharAt(i--);
                }
            }
        }
        count = 0;
        for(int i = buf.length() - 1; i >= 0; i--){
            if(buf.charAt(i) == ')')
                count++;
            else if(buf.charAt(i) == '('){
                if(count > 0)
                    count--;
                else
                    buf.deleteCharAt(i++);
            }
        }
        return buf.toString();
    }
//    static boolean isValide(String input){
//        int count = 0;
//        for(int i = 0;i < input.length(); i++){
//            if(input.charAt(i) == '(')
//                count++;
//            else if(input.charAt(i) == ')'){
//                if(count <= 0)
//                    return false;
//                else
//                    count--;
//            }
//        }
//        return count == 0;
//    }
}
