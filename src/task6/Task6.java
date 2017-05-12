package task6;

import java.util.*;

public class Task6 {
    public static void main(String[] args) {

        Scanner inSubName = new Scanner(System.in);
        System.out.println("Enter the name of submarine ===>");
        String subName = inSubName.nextLine();

        Scanner inSubCol = new Scanner(System.in);
        System.out.println("Enter the color of submarine ===>");
        String subColor = inSubCol.nextLine();

        Scanner inEngName = new Scanner(System.in);
        System.out.println("Enter the engine Firm name ===>");
        String engName = inEngName.nextLine();

        Scanner inEngPower = new Scanner(System.in);
        System.out.println("Enter the engine power (int) ===>");
        int engPower = inEngPower.nextInt();

        NuclearSubmarine.NuclearSubmarineEngine engine = new NuclearSubmarine().new NuclearSubmarineEngine(engName,engPower);

        NuclearSubmarine submarine = new NuclearSubmarine(subName,subColor,engine);

        submarine.go();
    }
}
class NuclearSubmarine {
    String name;
    String color;
    NuclearSubmarineEngine engine;
    NuclearSubmarine(String name, String color, NuclearSubmarineEngine engine){
          this.name = name;
          this.color = color;
          this.engine = engine;
    }
    NuclearSubmarine(){}
    void go(){
        System.out.println("Атомная лодка "+name+" цвета "+color+" с двигателем "+engine+" пущена в плавание");
    }
    class NuclearSubmarineEngine {
        String engineName;
        int powerOfEngine;
        NuclearSubmarineEngine(String engineName, int powerOfEngine){
            this.engineName = engineName;
            this.powerOfEngine = powerOfEngine;
        }

        @Override
        public String toString() {
            return "фирмы "+engineName+" мощностью "+powerOfEngine+" л.с.";
        }
    }
}
