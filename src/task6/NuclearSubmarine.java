package task6;


public class NuclearSubmarine {
    String name;
    String color;
    NuclearSubmarineEngine engine;
    public NuclearSubmarine(String name, String color, NuclearSubmarineEngine engine){
        this.name = name;
        this.color = color;
        this.engine = engine;
    }
    public NuclearSubmarine(){}
    public void go(){
        System.out.println("Атомная лодка "+name+" цвета "+color+" с двигателем "+engine+" пущена в плавание");
    }
    public class NuclearSubmarineEngine {
        String engineName;
        int powerOfEngine;
        public NuclearSubmarineEngine(String engineName, int powerOfEngine){
            this.engineName = engineName;
            this.powerOfEngine = powerOfEngine;
        }

        @Override
        public String toString() {
            return "фирмы "+engineName+" мощностью "+powerOfEngine+" л.с.";
        }
    }
}

