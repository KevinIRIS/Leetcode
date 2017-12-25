import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by kaizh on 12/14/2016.
 */
public class PocketGems {
    public static void main(String[] args) {
        List<String> lines = parseFile("C:\\Users\\kaizh\\Desktop\\input_2.txt");
        List<String> res = parseLines(lines);
        for (String i : res)
            System.out.println(i);
    }
    static List<String> parseFile(final String fileName){
        if(fileName == null)
            throw new IllegalArgumentException("IllegalArgument");
        File file = new File(fileName);
        BufferedReader reader = null;
        List<String> lines = new ArrayList<>();
        try {
             reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null){
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.print("File Not found!");
        } catch (IOException e) {
           System.out.print("I/O error");
        }
        return lines;
    }
    static List<String> parseLines(final List<String> lines){
        List<String> res = new ArrayList<>();
        if(lines.size() == 0)
            return res;
        Map<String,Set<String>> graph = new HashMap<>();

        int index = lines.get(0).indexOf(" ");
        String start = lines.get(0).substring(0,index);
        String des = lines.get(0).substring(index+1);
        for(int i = 1; i < lines.size(); i++){
            int j = lines.get(i).indexOf(":");
            String node = lines.get(i).substring(0,j - 1);
            String remains = lines.get(i).substring(j+2);
            Set<String> edge = new HashSet<>();
            for(String end : remains.split(" ")){
                edge.add(end);
            }
            if(!graph.containsKey(node)){
                graph.put(node,edge);
            }else{
                for(String k : edge)
                    graph.get(node).add(k);
            }
        }
        HashSet<String> visied = new HashSet<>();
        dfs(start,des,graph,res,new StringBuilder(),visied);
        return res;
    }
    static void dfs(String start, String des,Map<String,Set<String>> graph, List<String> res,StringBuilder path,Set<String> visited){
        visited.add(start);
        path.append(start);
        if(start.equals(des)){
            res.add(path.toString());
        }else{
            if(graph.get(start) != null) {
                Iterator<String> iterator = graph.get(start).iterator();
                while (iterator.hasNext()) {
                    String next = iterator.next();
                    if (!visited.contains(next)) {
                        dfs(next, des, graph, res, path, visited);
                    }
                }
            }
        }
        path.delete(path.length() - start.length(),path.length());
        visited.remove(start);
    }
}
