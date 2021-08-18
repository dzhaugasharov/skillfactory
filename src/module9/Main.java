package module9;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        //showTimer(1);
        readDir("C:\\");
    }

    static void showTimer(int minutes) {
        int prevSec = -1, currentSec, totalSeconds = minutes * 60;
        while (totalSeconds > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Calendar c = Calendar.getInstance();
            currentSec = c.get(Calendar.SECOND);
            if (currentSec == prevSec) continue;
            totalSeconds--;
            prevSec = currentSec;
            System.out.println(simpleDateFormat.format(new Date()));
        }
        System.out.println("Time is up!");
    }

    static void readDir(String path) {
        File file = new File(path);
        if (!file.isDirectory()) {
            System.out.println("It's not a directory!");
            return;
        }
        System.out.println(System.getProperty("file.encoding"));

        for (String f : file.list()) {
            File innerFile = new File(path + "\\" + f);
            if (innerFile.isDirectory()) System.out.println("/" + f + "/");
            else System.out.println(f);
        }
    }
}
