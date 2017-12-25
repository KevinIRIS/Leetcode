import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kaizh on 12/14/2016.
 */
public class PocketGems2 {
    static List<String> parseFile(final String fileName){
        if(fileName == null)
            throw new IllegalArgumentException();
        File file = new File(fileName);
        List<String > lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
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
    static String parseLines (final List<String> lines){
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss");
        double total = 0, online = 0;
        Date start = new Date(0), end = new Date(0), curTime = new Date(0), connect = new Date(0), disconnect = new Date(0);
        boolean isconnected = false;
        for(String line : lines){
            int index = line.indexOf("::");
            try {
                curTime = format.parse(line.substring(1,19));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String state = line.substring(index + 3);
            if(state.equals("START"))
                start = curTime;
            else if (state.equals("CONNECTED")){
                if(isconnected)
                    continue;
                else {
                    connect = curTime;
                    isconnected = true;
                }
            }else if (state.equals("DISCONNECTED")){
                if(!isconnected)
                    continue;
                else {
                    disconnect = curTime;
                    isconnected = false;
                    online += disconnect.getTime() - connect.getTime();
                }
            }else if (state.equals("SHUTDOWN")){
                end = curTime;
                total = end.getTime() - start.getTime();
            }
        }
        if(isconnected)
            online += end.getTime() - connect.getTime();
        isconnected = false;
        if(total == 0 )
            return "0%%";
        return (int)(online * 100 / total) + "%";
    }

    public static void main(String[] args) {
        List<String> lines = parseFile("C:\\Users\\kaizh\\Desktop\\input_2.txt");
        System.out.print(parseLines(lines));
    }
}
