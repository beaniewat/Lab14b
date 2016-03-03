// Lab14bvst.java
// This is one of the student starting files
// of the Lab14b lab assignment.
// This file tests all the classes together.
// and draws a train without proper OOP design.


import java.applet.Applet;
import java.awt.*;


public class Lab14bConatserWatersv100 extends Applet {
    public void paint(Graphics g) {
        Train train = new Train(100, 300);
        train.addCar("Locomotive", Color.blue);
        train.addCar("PassengerCar", Color.gray);
        train.addCar("PassengerCar", Color.gray);
        train.addCar("PassengerCar", Color.gray);
        train.addCar("FreightCar", Color.green);
        train.addCar("FreightCar", Color.green);
        train.addCar("FreightCar", Color.green);
        train.addCar("Caboose", Color.red);
        train.addCar(6,"Caboose", Color.blue);
        train.showCars(g);
    }
} 