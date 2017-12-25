import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kaizh on 11/5/2016.
 */
public class Palindrome267 {
    public List<String> generatePalindromes(String s) {
        Character midChar = null;
        HashMap<Character,Integer> dict = new HashMap<>();
        int oddCount = 0;
        for(int i = 0 ; i < s.length(); i++){
            Character curChar = s.charAt(i);
            dict.put(curChar,dict.getOrDefault(curChar,0) + 1);
        }
        ArrayList<Character> option = new ArrayList<>();
        for(Character key : dict.keySet()){
            if(dict.get(key) % 2 == 1){
                oddCount++;
                if(oddCount > 1)
                    return new LinkedList<String>();
            }
            dict.put(key, dict.get(key) / 2);
            for(int i = 0 ; i < dict.get(key); i++){
                option.add(key);
            }
        }
        List<String> res = new ArrayList<String> ();
        construct(option, res, new StringBuffer(),midChar,new boolean[option.size()]);
        return res;
    }
    public void construct(ArrayList<Character> option, List<String> res,StringBuffer buf, Character mid, boolean[] used){
        if(buf.length() == option.size()){
            if(mid == null)
                res.add(buf.toString() + buf.reverse().toString());
            else
                res.add(buf.toString() + String.valueOf(mid) + buf.reverse().toString());
            return;
        }
        for(int i = 0 ; i < option.size(); i++){
            if(used[i])
                continue;
            if(i > 0 && option.get(i) == option.get(i - 1) && !used[i - 1])
                continue;
            buf.append(option.get(i));
            used[i] = true;
            construct(option,res,buf,mid,used);
            buf.deleteCharAt(buf.length() - 1);
            used[i] = false;
        }
    }


}
