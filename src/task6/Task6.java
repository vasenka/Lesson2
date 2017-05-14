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
