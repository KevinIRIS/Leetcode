import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kaizh on 1/7/2017.
 */
public class AllPath {
    public List<String> getPath(char[][] graph){
        List<String> res = new ArrayList<>();
        if(graph == null)
            return res;
        dfs(graph,res,new StringBuilder(), 0,0);
        return res;
    }
    void  dfs(char[][] graph, List<String> res, StringBuilder buf, int row, int col){
        if(row == graph.length - 1 && col == graph[0].length - 1){
            buf.append(graph[row][col]);
            res.add(buf.toString());
            buf.deleteCharAt(buf.length() - 1);
            return;
        }else if(row >= graph.length || col >= graph[0].length)
            return;
        buf.append(graph[row][col]);
        dfs(graph,res,buf,row,col+1);
        dfs(graph,res,buf,row+1,col);
        buf.deleteCharAt(buf.length() - 1);
    }

    public static void main(String[] args) {
//        char[][] graph = new char[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'}};
        char[][] graph = new char[][]{{'a','b'},{'c','d'}};
        System.out.print(new AllPath().getPath(graph));
    }
}
