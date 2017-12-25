/**
 * Created by kaizh on 1/7/2017.
 */
public class FirstNoneMatchLeaves {
    public String[] noneMatch(String[] tree1 , String[] tree2){
        String[] res = new String[2];
        int i = 0, j = 0, len1 = tree1.length, len2 = tree2.length;
        while(true){
            while(i < len1){
                if(i + 2 < len1 && tree1[i+1] == "null" && tree1[i+2] == "null"){
                    break;
                }
                i++;
            }
            while(j < len2){
                if(j + 2 <len2 && tree2[i + 1] == "null" && tree2[j + 2] == "null"){
                    break;
                }
                j++;
            }
            if(i >= len1 || j >= len2)
                return new String[]{"null","null"};
            if(tree1[i] != tree2[j]){
                return new String[]{tree1[i], tree2[j]};
            }
            i++;
            j++;
        }
    }
}
