package lesson11;

import java.util.Random;

public class CheckPointRunner {

    private static final String CYRILLIC_CHARACTERS = "АВЕКМНОРСТХ";

    public static void main(String[] args) {
        CheckPoint checkPoint = new CheckPoint(80, 100, 8, 4, 2.5);
        Auto[] autos = new Auto[10];
        for (int i = 0; i < autos.length; i++) {
            if (i < autos.length / 2) {
                autos[i] = new Car(
                        generateRegNumber(),
                        round(new Random().nextDouble(5)),
                        round(new Random().nextDouble(3)),
                        round(new Random().nextDouble(3)),
                        round(new Random().nextDouble(4))
                );
            } else {
                autos[i] = new Truck(generateRegNumber(),
                        round(new Random().nextDouble(15)),
                        round(new Random().nextDouble(6)),
                        round(new Random().nextDouble(4)),
                        round(new Random().nextDouble(20))
                );
            }
        }

        for (Auto auto : autos) {
            try {
                auto.setSpeed(new Random().nextInt(120));
                checkPoint.check(auto);
                System.out.println("Автомобиль " + auto.getRegNumber() + " проехал через КПП");
            } catch (IllegalStateException e) {
                System.out.println("Выявлено нарушение при проезде через КПП: " + e.getMessage());
            }
        }
    }

    private static String generateRegNumber() {
        var random = new Random();
        return String.valueOf(CYRILLIC_CHARACTERS.charAt(random.nextInt(CYRILLIC_CHARACTERS.length()))) +
                random.nextInt(9) +
                random.nextInt(9) +
                random.nextInt(9) +
                CYRILLIC_CHARACTERS.charAt(random.nextInt(CYRILLIC_CHARACTERS.length())) +
                CYRILLIC_CHARACTERS.charAt(random.nextInt(CYRILLIC_CHARACTERS.length()));

    }

    private static double round(double value) {
        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
