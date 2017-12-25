import java.util.Stack;

/**
 * Created by kaizh on 1/11/2017.
 */
public class MatchPairing {
    public int findMatchPairing(String input){
        int res = -1;
        Stack<Character> stack = new Stack<>();
        for(int i =0; i < input.length(); i++){
            char cur = input.charAt(i);
            if(!Character.isAlphabetic(cur))
                break;
            else if(Character.isUpperCase(cur))
                stack.push(cur);
            else {
                if(stack.isEmpty())
                    break;
                else {
                    if(stack.peek() == Character.toUpperCase(cur)){
                        res = i;
                        stack.push(cur);
                    }else
                        break;
                }
            }
        }
        return res;
    }
}
