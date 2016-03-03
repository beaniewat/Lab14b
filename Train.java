import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Train {
    private ArrayList<RailCar> railCars = new ArrayList<>();
    private int x;
    private int y;

    public Train(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addCar(String type, Color c) {
        try {
            Class carType = Class.forName(type);
            Constructor carTypeConst = carType.getConstructor(Color.class, int.class, int.class);

            RailCar rc = (RailCar) carTypeConst.newInstance(c, x, y);
            this.x += 175;
            railCars.add(rc);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addCar(int loc, String type, Color c) {
        try {
            Class carType = Class.forName(type);
            Constructor carTypeConst = carType.getConstructor(Color.class, int.class, int.class);

            int xPos = railCars.get(loc).getXPos();

            RailCar rc = (RailCar) carTypeConst.newInstance(c, xPos, y);
            this.x += 175;
            RailCar moveRc = railCars.get(loc);
            railCars.set(loc, rc);
            for (int i = loc; i < railCars.size(); i++) {
                RailCar temp = moveRc;
                if (railCars.get(i+1) != null) {
                    moveRc = railCars.get(i+1);
                    temp.setXPos(moveRc.getXPos());
                    railCars.set(i + 1, temp);
                } else {
                    temp.setXPos(temp.getXPos()+175);
                    railCars.add(temp);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void showCars(Graphics g) {
        for (RailCar rc : railCars) {
            rc.drawCar(g);
        }
    }
}
