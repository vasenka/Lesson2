package task4;

import java.util.*;

public class Task4 {
    static final NameComparator nameComparator = new NameComparator();
    static final PriceComparator priceComparator = new PriceComparator();
    static final BiComparator biComparator = new BiComparator(nameComparator,priceComparator);
    public static void main(String[] args) {

        BasicSet[] basicSet = generateBasicSet();
        System.out.println("Before sorting ===================");
        printArray(basicSet);

        System.out.println("Sort by name ===================");
        Arrays.sort(basicSet, nameComparator);

        printArray(basicSet);

        System.out.println("Sort by price ===================");
        Arrays.sort(basicSet, priceComparator);

        printArray(basicSet);

        System.out.println("Sort by name then by price ===================");
        Arrays.sort(basicSet, biComparator);

        printArray(basicSet);
    }
    static BasicSet[] generateBasicSet() {
        String[] name1 = {"Простой","карандаш"};
        String[] name2 = {"Простой","карандаш"};
        String[] name3 = {"Шариковая","ручка","черная"};
        String[] name4 = {"Шариковая","ручка","синяя"};
        String[] name5 = {"Ножницы"};
        String[] name6 = {"Ножницы"};
        return new BasicSet[]{
                new BasicSet(name1,5.50),
                new BasicSet(name2,11.50),
                new BasicSet(name3,10.00),
                new BasicSet(name4,10.00),
                new BasicSet(name5,55.50),
                new BasicSet(name6,78.90),
        };
    }
    static void printArray(BasicSet[] basicSet) {
        for (BasicSet bs : basicSet) {
            System.out.println(bs);
        }
    }
}
class BasicSet{
    String[] name;
    double price;

    String priceKopeyki;

    BasicSet(String[] name, double price){
        this.name = name;
        this.price = price;
        priceKopeyki = ""+(price -(int)price);
    }

    String fullName = "";
    @Override
    public String toString() {
        for (int i=0;i<name.length;i++) {
            fullName = fullName + name[i]+" ";
        }
        String res = fullName+"  "+(int)price+"р."+priceKopeyki.charAt(2)+"0 коп.";
        fullName = "";
        return res;
    }
}

class NameComparator implements Comparator<BasicSet> {

    @Override
    public int compare(BasicSet o1, BasicSet o2) throws ArrayIndexOutOfBoundsException {
        int i = 0;
        int res = 0;
        try {
             res = o1.name[i].compareTo(o2.name[i]);
            while (res == 0) {
                i++;
                res = o1.name[i].compareTo(o2.name[i]);
                // i++;
            }

            return res;
        } catch (ArrayIndexOutOfBoundsException e) {}
        finally {
            return res;
        }

    }
}
class PriceComparator implements Comparator<BasicSet> {

    @Override
    public int compare(BasicSet o1, BasicSet o2) {
        int res;
        if (o1.price == o2.price) {
            res = 0;
        } else if (o1.price >o2.price) {
            res = 1;
        } else res = -1;

        return res;
    }
}
class BiComparator implements Comparator<BasicSet> {
    Comparator<BasicSet> cpm1;
    Comparator<BasicSet> cpm2;
    BiComparator(Comparator<BasicSet> cpm1, Comparator<BasicSet> cpm2) {
        this.cpm1 = cpm1;
        this.cpm2 = cpm2;
    }

    @Override
    public int compare(BasicSet o1, BasicSet o2) {
       int res = cpm1.compare(o1,o2);
        if (res==0) {
            res = cpm2.compare(o1,o2);
        }
        return res;
    }
}