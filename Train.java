public class Train {
  private ArrayList<RailCar> railCars = new ArrayList<>;
  private int x;
  private int y;
  
  public Train(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public void addCar(String type, Color c) {
    Class carType = Class.forName(type);
    Constructor carTypeConst = carType.getConstructor({Color});
    
    RailCar rc = carTypeConst.getInstance(c,x,y);
    this.x += 175;
    railCars.add(rc);
  }
  
  public void showCars(Graphics g) {
    for (RailCar rc:railCars) {
      rc.drawCar(g);
    }
  }
}
