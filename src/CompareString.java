import java.util.Comparator;

/**
 * Created by kaizh on 12/3/2016.
 */
public class CompareString implements Comparator<String>{
    int index1 = 0, index2 = 0;
    public int compare(String s1, String s2) {
        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) == s2.charAt(index2) && Character.isLetter(s1.charAt(index1))){ // all letter
                index1++;
                index2++;
            }else if(Character.isDigit(s1.charAt(index1)) && Character.isDigit(s2.charAt(index2))){ //all digit
                int num1 = 0;
                int num2 = 0;
                while(index1 < s1.length() && Character.isDigit(s1.charAt(index1))){
                    num1  = num1 * 10 + s1.charAt(index1) - '0';
                    index1++;
                }
                while (index2 < s2.length() && Character.isDigit(s2.charAt(index2))){
                    num2 = num2 * 10 + s2.charAt(index2) - '0';
                    index2++;
                }
                if(num1 > num2)
                    return 1;
                if(num1 < num2)
                    return -1;
            }else{  // not equals or one digit and one letter
                    if(Character.isDigit(s1.charAt(index1)))
                        return -1;
                    else if(Character.isDigit(s2.charAt(index2)))
                        return 1;
                    if(s1.charAt(index1) < s2.charAt(index2))
                        return -1;
                    return 1;
            }
        }
        if(s1.length() > s2.length())
            return 1;
        else if(s1.length() < s2.length())
            return -1;
        return 0;
    }

    public static void main(String[] args) {
        System.out.print(new CompareString().compare("aa023","aa0234"));
    }
}
