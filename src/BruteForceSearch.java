import java.awt.*;

public class BruteForceSearch {
    public static void main(String[] args) {
        int[] sameTest1 = {1, 2};
        int[] sameTest2 = {2, 2, 2, 1, 1, 1};
        int[] sameTest3 = {3, 4};
        int[] sameTest4 = {4, 4, 2, 3, 3, 3};
        System.out.println(sameValues(sameTest1, sameTest2));
        System.out.println(sameValues(sameTest3, sameTest4));
        int[] validTest1 = {5, 7, 2, 3, 4, 9, 1, 6, 8};
        int[] validTest2 = {1, 2, 3, 6, 8, 9, 4, 5, 7, 0};
        int[] validTest3 = {1, 2, 3, 9, 5, 6, 7, 8, 9};
        System.out.println(isValid(validTest1));
        System.out.println(isValid(validTest2));
        System.out.println(isValid(validTest3));
        String[] compoundTest1 = {"fire", "place", "cat", "kitty", "kittycat", "fire", "fireplace"};
    }

    public static boolean sameValues(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    break;
                } else if (j == arr2.length - 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length && j < arr2.length; j++) {
                if (arr2[i] == arr1[j]) {
                    break;
                } else if (j == arr1.length - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(int[] row) {
        if (row.length != 9) {
            return false;
        } else {
            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    if (row[j] == i) {
                        break;
                    } else if (j == 8) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int countCompounds(String[] words) {
        int compounds = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String compound = words[i] + words[j];
                for (int k = j + 1; k < words.length; k++) {
                    if (words[k].contains(compound)) {
                        compounds++;
                    }
                }
                compound = words[j] + words[i];
                for (int k = j + 1; k < words.length; k++) {
                    if (words[k].contains(compound)) {
                        compounds++;
                    }
                }
            }
        }
        return compounds;
    }

    public static Point[] largestTriangle(Point[] points) {
        int largestArea = Integer.MIN_VALUE;
        Point[] toReturn = new Point[3];
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    int area = 0;
                    if (area > largestArea) {
                        largestArea = area;
                        //set toReturn to points.get(i), points.get(j), points,get(k)
                    }
                }
            }
        }
        return toReturn;
    }
}
