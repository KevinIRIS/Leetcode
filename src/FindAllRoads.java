/**
 * Created by Tory on 12/11/16.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FindAllRoads {

    public static List<String> findRoads() throws IOException{
        File file = new File("/Users/Tory/Desktop/graph.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> res = new ArrayList<>();

        String[] points = reader.readLine().split(" ");
        char destination = points[1].charAt(0),source = points[0].charAt(0);
        Map<Character,Set<Character>> graph = new HashMap<>();
        String str = reader.readLine();
        while(str != null){
            String[] edges = str.split(":");
            char point = edges[0].charAt(0);
            String[] neighbors = edges[1].split(" ");
            Set<Character> set = new HashSet<>();
            for(String neighbor : neighbors){
                if(!neighbor.equals(""))
                    set.add(neighbor.charAt(0));
            }
            graph.put(point,set);
            str = reader.readLine();
        }
        findAllRoads(destination,graph,new boolean[26],source,res,new StringBuilder());
        return res;
    }

    public static void findAllRoads(char destination,Map<Character,Set<Character>> graph,boolean[] visited,char current,List<String> res,StringBuilder sb){
        if(current == destination){
            res.add(sb.toString() + destination);
            return ;
        }

        Set<Character> neighbors = graph.get(current);
        if(neighbors == null)
            return ;
        visited[current - 'A'] = true;
        sb.append(current + "->");
        for(char neighbor : neighbors){
            if(!visited[neighbor - 'A']){
                findAllRoads(destination,graph,visited,neighbor,res,sb);
            }
        }
        sb.delete(sb.length() - 3,sb.length());
        visited[current - 'A'] = false;
    }

    private static double logParser() throws Exception{
        File file = new File("/Users/Tory/Desktop/date.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss");
        long connectedTime = 0,sessionTime = 0;
        Deque<Date> deque = new ArrayDeque<>();
        Deque<String> states = new ArrayDeque<>();
        String contents = reader.readLine();
        while(contents != null){
            String[] data = contents.split("::");
            String date = data[0].substring(1,data[0].length() - 2);
            String state = data[1].trim();
            Date pre = null;
            switch(state){
                case "START":
                    states.addFirst(state);
                    deque.addFirst(format.parse(date));
                    break;
                case "CONNECTED":
                    states.addFirst(state);
                    deque.addFirst(format.parse(date));
                    break;
                case "DISCONNECTED":
                    pre = deque.removeFirst();
                    states.removeFirst();
                    connectedTime += format.parse(date).getTime() - pre.getTime();
                    break;
                case "SHUTDOWN":
                    while(!deque.isEmpty()){
                        pre = deque.removeFirst();
                        String preState = states.removeFirst();
                        if(preState.equals("CONNECTED"))
                            connectedTime += format.parse(date).getTime() - pre.getTime();
                        else if(preState.equals("START"))
                            sessionTime += format.parse(date).getTime() - pre.getTime();
                    }
            }
            contents = reader.readLine();
        }
        return (double)connectedTime / sessionTime;
    }

    public static void main (String[] args)throws Exception{
        Map<Character,Set<Character>> graph = new HashMap<>();
        Set<Character> edge = new HashSet<>();
        edge.add('B');edge.add('C');edge.add('D');
        graph.put('A',edge);
        Set<Character> edge1 = new HashSet<>();
        edge1.add('C');graph.put('B',edge1);
        Set<Character> edge2 = new HashSet<>();
        edge2.add('E');graph.put('C',edge2);
        edge2 = new HashSet<>();
        edge2.add('B');graph.put('E',edge2);
        List<String> res = findRoads();
        for(String i : res){
            System.out.println(i);
        }
        //System.out.println(logParser());
    }
}