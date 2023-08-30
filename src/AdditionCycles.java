import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdditionCycles {
    public static void main(String[] args) {
        //placeholder
    }

    public static void additionCycle() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i + ", " + j + ": " + createCycle(i, j) + ", length: " + cycleLength(createCycle(i, j)));
            }
        }
    }

    public static ArrayList<Integer> createCycle(int first, int second) {
        int counter;
        ArrayList<Integer> cycle = new ArrayList<>();
        cycle.add(first);
        cycle.add(second);
        for (int i = 2; cycle.get(0) + cycle.get(1) != cycle.get(i - 1) + cycle.get(i - 2); i++) {
            if (cycle.get(i - 1) + cycle.get(i - 2) > 9) {
                cycle.add((cycle.get(i - 1) + cycle.get(i - 2)) % 10);
            }
        }
        return cycle;
    }

    public static int cycleLength(ArrayList<Integer> cycle) {
        return -1;
    }
}