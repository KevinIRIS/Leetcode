import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Tory on 1/12/17.
 */
public class ValidParentheses {

    public static boolean isValid(String s){
        if(null == s || "".equals(s))
            return true;
        Deque<Character> stack = new ArrayDeque<>();
        int length = s.length();
        for(int i = 0; i < length; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '}':
                    if (!stack.isEmpty() && stack.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.pop() != '[')
                        return false;
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.pop() != '(')
                        return false;
                    break;
                default:
                    stack.addFirst(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{(())}";
        System.out.println(isValid(s));
    }
}
