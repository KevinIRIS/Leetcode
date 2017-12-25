import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by kaizh on 1/3/2017.
 */
public class Line {
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();
    private LinkedList<Integer> line = new LinkedList<>();
    public void produce(Integer x){
        writeLock.lock();
        try{
            line.add(x);
        }finally {
            writeLock.unlock();
        }
    }
    public Integer consume(){
        readLock.lock();
        Integer item = null;
        try{
            if(line.size() != 0)
                item =  line.poll();
        }finally {
            readLock.unlock();
        }
        return item;
    }
}
class Producer extends Thread{
    Line line = null;
    public Producer(Line line){
        this.line = line;
    }
    public void run(){
        Random random = new Random();
        while(true){
            int x = random.nextInt(1000000);
            line.produce(x);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stopProducing(){
        this.interrupt();
    }
}
class Consumer extends Thread{
    Line line = null;
    public Consumer (Line line){
        this.line = line;
    }
    public void run(){
        while(true){
            Integer item = line.consume();
            if(item != null)
                System.out.print(item);

            try{
                Thread.sleep(100);
            }catch (InterruptedException x){
                x.printStackTrace();
            }
        }
    }
}
