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
        System.out.println(countCompounds(compoundTest1));
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(3,3);
        Point d = new Point(10, 5);
        Point e = new Point(3, 7);
        Point[] points = {a, b, c, d, e};
        Point[] triangle = largestTriangle(points);
        System.out.println(triangle[0]);
        System.out.println(triangle[1]);
        System.out.println(triangle[2]);
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
                for (int k = 0; k < words.length; k++) {
                    if (words[k].contains(compound)) {
                        compounds++;
                        System.out.println(words[k]);
                    }
                }
                compound = words[j] + words[i];
                for (int k = 0; k < words.length; k++) {
                    if (words[k].contains(compound)) {
                        compounds++;
                        System.out.println(words[k]);
                    }
                }
            }
        }
        return compounds;
    }

    public static Point[] largestTriangle(Point[] points) {
        double largestArea = Integer.MIN_VALUE;
        Point[] toReturn = new Point[3];
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double a = getDistance(points[i], points[j]);
                    double b = getDistance(points[i], points[k]);
                    double c = getDistance(points[j], points[k]);
                    double s = (a + b + c)/2;
                    double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                    if (area > largestArea) {
                        largestArea = area;
                        toReturn[0] = points[i];
                        toReturn[1] = points[j];
                        toReturn[2] = points[k];
                    }
                }
            }
        }
        return toReturn;
    }

    private static double getDistance(Point a, Point b) {
        return Math.sqrt((Math.pow((b.getX() - a.getX()), 2.0)) + (Math.pow((b.getY() - a.getY()), 2.0)));
    }
}
