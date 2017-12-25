import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by kaizh on 1/7/2017.
 */
public class MergeKArrays {
    public int[] sort(int [][] arrays){
        PriorityQueue<ArrayContainer> pq = new PriorityQueue<>();
        int total = 0;
        for(int[] array : arrays){
            if(array != null && array.length != 0) {
                pq.offer(new ArrayContainer(array, 0));
                total += array.length;
            }
        }
        int[] res = new int[total];
        int index = 0;
        while(!pq.isEmpty()){
            ArrayContainer cur = pq.poll();
            res[index++] = cur.array[cur.index++];
            if(cur.index < cur.array.length)
                pq.offer(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        int[] result = new MergeKArrays().sort(new int[][] { arr1, arr2, arr3 });
        System.out.println(Arrays.toString(result));
    }

}
//class  ArrayContainer implements Comparable<ArrayContainer>{
//    int[] array = null;
//    int index ;
//    public ArrayContainer(int[] array, int index){
//        this.array = array;
//        this.index = index;
//    }
//    public int compareTo(ArrayContainer c){
//        return array[index] - c.array[c.index];
//    }
//}
class ArrayContainer implements Comparable<ArrayContainer>{
    int[] array;
    int index;
    public ArrayContainer(int[] array, int index){
        array = array;
        this.index = index;
    }
    public int compareTo(ArrayContainer c){
        return this.array[index] - c.array[c.index];
    }
}