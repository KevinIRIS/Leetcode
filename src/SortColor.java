import sun.nio.cs.ext.MacHebrew;

import java.util.HashMap;

/**
 * Created by kaizh on 11/29/2016.
 */
public class SortColor {
    public static void main(String[] args) {
        int[] input = new int[]{-5 ,- 2 , 2 , 3, 7};
        int[] output = new int[input.length];
        int index = input.length -1;
        int head =0, tail = input.length - 1;
        while(head <= tail){
            if(Math.abs(input[head]) < Math.abs(input[tail])){
                output[index--] =  input[tail] * input[tail];
                tail--;
            }else {
                output[index--] = input[head] * input[head];
                head++;
            }
        }
        for(int i : output)
            System.out.print(i + " ");
    }
}
