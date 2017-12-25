/**
 * Created by kaizh on 11/21/2016.
 */
public class StringCompression {

    public static void main (String[] args){
        System.out.print( new StringCompression().compress("abx"));
    }
    public String compress(String original){
        if(original == null)
            return original;
        StringBuilder buffer = new StringBuilder();
        Character cur = null;
        int count = 0;
        for(char i : original.toCharArray()){
            if(cur == null){
                cur = i;
                count = 1;
            }else{
                if(cur == i)
                    count++;
                else{
                    buffer.append(cur);
                    buffer.append(count);
                    cur = i;
                    count = 1;
                }
            }
        }
        if(cur != null) {
            buffer.append(cur);
            buffer.append(count);
        }
        return buffer.length() >= original.length() ? original :buffer.toString();
    }

}
