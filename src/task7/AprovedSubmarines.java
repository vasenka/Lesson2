package task7;

import java.lang.annotation.*;

import task6.NuclearSubmarine;
import task6.NuclearSubmarine.NuclearSubmarineEngine;


@Documented
@Target(value= ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface AprovedSubmarines{
       String color();
}

@AprovedSubmarines(color = "yellow")
class SwimToHongKong {

    String engName;
    int power;
    String subName;
    String subColor;

    SwimToHongKong(String engName, int engPower, String subColor, String subName) throws ClassNotFoundException {
        this.engName = engName;
        this.power = engPower;
        this.subColor = subColor;
        this.subName = subName;


        NuclearSubmarine.NuclearSubmarineEngine engine = new NuclearSubmarine().new NuclearSubmarineEngine(engName, power);

        NuclearSubmarine submarine = new NuclearSubmarine(subName, subColor, engine);
        submarine.go();
    }

  //  Class<?> cl = Class.forName("SwimToHongKong");
}

