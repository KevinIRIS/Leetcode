/**
 * Created by kaizh on 12/6/2016.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.print(romanToInt("IX"));
    }
    public static int romanToInt(String s) {
        if(s == null||s.length()==0){
            throw new IllegalArgumentException("no solution.");
        }
        int result = 0;
        for(int index = s.length()-1;index>=0;index--){
            Character c = s.charAt(index);
            switch(c){
                case 'I':
                    result +=(result>=5?-1:1);
                    break;
                case 'V':
                    result +=5;
                    break;
                case 'X':
                    result +=(result>=50?-10:10);
                    break;
                case 'L':
                    result +=50;
                    break;
            }
        }
        return result;
    }
}
