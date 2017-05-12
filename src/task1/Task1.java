package task1;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {

// Entering first pen
        Pen pen = EnterPen.enterPen();
        System.out.println(pen);
        System.out.println(pen.hashCode());
// Entering second pen
        Pen anotherPen = EnterPen.enterPen();
        System.out.println(anotherPen);
        System.out.println(anotherPen.hashCode());
// Checking pens by equals
        System.out.println(pen.equals(anotherPen));

    }
}
class Pen {
  /** The field of pen's color(s) */
  String color;
  /** The field of pen's length */
  double length;
  /** The field of country where this pen was produced */
  String produser;
  /** The field of pen's type :ballpoint, gel, fountain */
  String type;

    public Pen(String color, double length, String produser, String type) {
        this.color = color;
        this.length = length;
        this.produser = produser;
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pen) {
            Pen anotherPen = (Pen)obj;
            if ((color.equals(anotherPen.color)) && ((length == anotherPen.length) && ((produser.equals(anotherPen.produser)) && (type.equals(anotherPen.type))))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
       return ((int) color.charAt(0) + (int)Math.pow(length,2) +
               (int)Math.pow((int)produser.charAt(0),3) +
               (int)Math.pow((int)type.charAt(0),4));
    }

    @Override
    public String toString() {
        return type + " pen, color: "+ color+ " length: "+ length+" , produced by "+produser;
    }

}
class EnterPen {
    static Pen enterPen() {
        Scanner inColor = new Scanner(System.in);
        System.out.println("Enter color of pen===>");
        String color = inColor.next();

        Scanner inLength = new Scanner(System.in);
        System.out.println("Enter length of pen===>");
        double length = inLength.nextDouble();

        Scanner inProducer = new Scanner(System.in);
        System.out.println("Enter country of pen===>");
        String producer = inProducer.next();

        Scanner inType = new Scanner(System.in);
        System.out.println("Enter type of pen===>");
        String type = inType.next();

        return new Pen(color, length, producer, type);
    }
}
