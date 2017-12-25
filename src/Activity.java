//import java.util.PriorityQueue;
//
///**
// * Created by kaizh on 12/5/2016.
// */
//public class Activity {
//    List<Act> maxAct(List<Act> input){
//        input.sort(new Comparator<Act>(){
//            public int compare (Act i , Act j){
//                return i.end - j.end;
//            }
//        });
//        List<Act> res = new ArrayList<>();
//        for(Act i : input){
//            if(res.size == 0)
//                res.add(i);
//            else{
//                if(i.start >= res.get（res.size() - 1).end)
//                    res.add(i);
//            }
//        }
//        return res;
//    }
//}
