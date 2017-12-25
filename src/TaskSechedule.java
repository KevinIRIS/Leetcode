import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kaizh on 1/4/2017.
 */
public class TaskSechedule {
    public  List<String> missionOrder(int[] mission, int col){
        List<String> res = new ArrayList<>();
        if(mission == null )
            return res;
        HashMap<Integer,Integer> timeMap = new HashMap<>();
        int time = 0;
//        for(int i = 0; i < mission.length; i++){
//            while(timeMap.containsKey(mission[i]) && timeMap.get(mission[i]) + col >=time){
//                res.add("_");
//                time++;
//            }
//            res.add(String.valueOf(mission[i]));
//            timeMap.put(mission[i],time);  // start time
//            time++;
//        }
        for(int task : mission){
            if(timeMap.containsKey(task) && timeMap.get(task) + col >= time){
                int interval = timeMap.get(task) + col - time + 1;
                for(int i = 0; i < interval; i++)
                    res.add("_");
                time += interval;
            }
            timeMap.put(task,time);
            res.add(task +"");
            time++;
        }
        return res;

    }
    public int missionOrder1(int[] tasks, int col){
        if(tasks == null)
            return 0;
        int time = 0;
        HashMap<Integer, Integer> timeMap = new HashMap<>();
//        for(int task : tasks){
//            if(!timeMap.containsKey(task)){
//                timeMap.put(task,time);
//            }else if(timeMap.get(task) + col >= time){
//                time += timeMap.get(task) + col - time + 1;
//                timeMap.put(task,time);
//            }else
//                timeMap.put(task,time);
//            time++;
//        }
        for(int task : tasks){
            if(timeMap.containsKey(task) && timeMap.get(task) + col >= time){
                time += timeMap.get(task) + col - time + 1;
            }
            timeMap.put(task,time);
            time++;
        }
        return time;
    }


    public static void main(String[] args) {
        int [] test = {  1, 2, 1, 1, 3, 4};
//        List<String> res = new TaskSechedule().missionOrder(test,6);
//        for(String i : res)
            System.out.print( new TaskSechedule().missionOrder1(test,2));
    }
}
