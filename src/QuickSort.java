/**
 * Created by kaizh on 12/14/2016.
 */
public class QuickSort {
    void quickSort(int[] nums, int left ,int right){
        if(left < right){
            int p = nums[right];
            int index = left;
            for(int i = left; i <= right - 1; i ++){
                if(nums[i] <= p)
                    swap(nums,index++,i);
            }
            swap(nums,index,right);
            quickSort(nums,left,index - 1);
            quickSort(nums,index + 1,right);
        }
    }
    void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] test = {2,1,24,31,5,6,2,56};
        new QuickSort().quickSort(test,0,test.length - 1);
        for(int i : test)
            System.out.print(i + " ");
    }
}
