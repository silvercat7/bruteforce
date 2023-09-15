package montecarlo;

public class MontyHall {
    public static boolean switchDoors() {
        int correct = 3;
        int choice = (int) (Math.random() * 3) + 1;
        int open;
        if (choice == correct) {
            open = (int) (Math.random() * 2) + 1;
        } else {
            open = 3 - choice;
        }
        int temp = choice;
        choice = 6 - temp - open;
        return choice == correct;
    }

    public static boolean doNotSwitch() {
        int correct = 3;
        int choice = (int) (Math.random() * 3) + 1;
        return choice == correct;
    }

    public static void average() {
        int switchTotal = 0;
        for (int i = 0; i < 10000; i++) {
            if (switchDoors()) {
                switchTotal++;
            }
        }
        System.out.println("by switching, you will win ~" + (switchTotal/10000.0) * 100 + "% of the time");
        int stayTotal = 0;
        for (int i = 0; i < 10000; i++) {
            if (doNotSwitch()) {
                stayTotal++;
            }
        }
        System.out.println("by not switching, you will win ~" + (stayTotal/10000.0) * 100 + "% of the time");
    }
}
