package task7;


public class Task7 {
    public static void main(String[] args) throws ClassNotFoundException {

        SwimToHongKong swimToHongKong = new SwimToHongKong("Hundai",10,"red","A111");
        Class<?> cl = Class.forName("task7.SwimToHongKong");
        AprovedSubmarines aprovedSubmarines = cl.getAnnotation(AprovedSubmarines.class);
        if (aprovedSubmarines != null) {
            if (swimToHongKong != null && swimToHongKong.subColor.equals(aprovedSubmarines.color())) {
                System.out.println("Доплыли удачно!");
            } else System.out.println("Разворачивай! В таком цвете не доплывем!");
        }
    }
}
