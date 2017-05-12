package task3;


import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {

        Stationery[] basicSet = {new SimplePencils(5.50), new BallPointPens("blue", 10), new BallPointPens("black", 10), new Nojnici(78.90)};

        System.out.println("Набор новичка: \n" + Arrays.toString(basicSet));
    }
}
class Stationery {
    final String NAME = "Кацелярские товары";
    void use() {
        System.out.println("Кацелярские товары - для работы и творчества");
    }
}
class Pencils extends Stationery {
    final String NAME = "Карандаши";

    @Override
    void use() {
        System.out.println("Карандашами чертят и рисуют");
    }
}
class SimplePencils extends Pencils {
    final String NAME = "Простой карандаш";
    double price;
    SimplePencils(double price){
        this.price = price;
    }

    @Override
    void use() {
        System.out.println("Простой карандаш нужен для чертежей и зариосвок");
    }

    @Override
    public String toString() {
        return NAME;
    }
}
class ColorPencils extends Pencils {
    final String NAME = "Цветной карандаш";
    String color;
    double price;
    ColorPencils(String color, double price) {
        this.color = color;
        this.price = price;
    }
    @Override
    void use() {
        System.out.println("Цветной карандаш нужен для создания цветных сюжетов");
    }
}
class Pens extends Stationery {
    final String NAME = "Ручки";
    @Override
    void use() {
        System.out.println("Ручки нужны для письма");
    }
}
class BallPointPens extends Pens {
    final String NAME = "Шариковая ручка";
    String color;
    double price;

    BallPointPens(String color, double price) {
        this.color = color;
        this.price = price;
    }
    @Override
    void use() {
        System.out.println("Шариковые ручки дешевые, долгого использования, массового употребления");
    }
    @Override
    public String toString() {
        return NAME+" "+color;
    }
}
class CuttingStuff extends Stationery {
    final String NAME = "Инструменты для резки";

    @Override
    void use() {
        System.out.println("Инструментами для резки являются: ножницы, нож для резки, бритва");
    }
}
class Nojnici extends CuttingStuff {
    final String NAME = "Ножницы";
    double price;
    Nojnici(double price) {
        this.price = price;
    }
    @Override
    void use() {
        System.out.println("Канцелярскими ножницами режут бумагу, веревки, картон и многое другое");
    }
    @Override
    public String toString() {
        return NAME;
    }
}