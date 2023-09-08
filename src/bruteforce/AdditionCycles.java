package bruteforce;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdditionCycles {
    public static void main(String[] args) {
        additionCycle();
        System.out.println("max lengths:");
        maxAdditionCycleLength();
        System.out.println("min lengths:");
        minAdditionCycleLength();
    }

    public static void additionCycle() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i + ", " + j + ": length " + createCycle(i, j));
            }
        }
    }

    public static int createCycle(int first, int second) {
        int counter = 2;
        int prev = (first + second) % 10;
        int current = (second + prev) % 10;
        boolean end = false;
        while (!end) {
            int temp = current;
            current = (current + prev) % 10;
            prev = temp;
            counter++;
            if (prev == first) {
                if (current == second) {
                    end = true;
                }
            } else if (prev == second) {
                if (current == first) {
                    end = true;
                }
            }
        }
        return counter;
    }

    public static void maxAdditionCycleLength() {
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (createCycle(i, j) >= maxLength) {
                    maxLength = createCycle(i, j);
                }
            }
        }
        System.out.println(maxLength);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (createCycle(i, j) == maxLength) {
                    System.out.println(i + ", " + j);
                }
            }
        }
    }

    public static void minAdditionCycleLength() {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (createCycle(i, j) <= minLength) {
                    minLength = createCycle(i, j);
                }
            }
        }
        System.out.println(minLength);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (createCycle(i, j) == minLength) {
                    System.out.println(i + ", " + j);
                }
            }
        }
    }
}