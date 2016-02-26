import java.awt.*;
import java.applet.*;
import java.util.ArrayList;
import java.lang.reflect.*;

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
    
    RailCar rc = (RailCar) carTypeConst.newInstance(c,x,y);
    this.x += 175;
    railCars.add(rc);
    } catch(Exception e) { 
      System.out.println(e);
      }
  }
  
  public void showCars(Graphics g) {
    for (RailCar rc:railCars) {
      rc.drawCar(g);
    }
  }
}
