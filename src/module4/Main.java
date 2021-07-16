package module4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Tank tank = new Tank();
        //        Tank tank = new Tank();
//        tank.goForward(10);
//        tank.printPosition();
//        tank.turnRight();
//        tank.goForward(50);
//        tank.printPosition();
//        tank.turnLeft();
//        tank.goBackward(100);
//        tank.printPosition();

        LimitingRectangle r = new LimitingRectangle(new int[][] {{-1, -2}, {3, 4}});
        System.out.println(r.getWidth() + " " + r.getHeight());
        System.out.println(r.getBorders());
    }
}
