public class ParticleDisplacement {
    public static void main(String[] args) {
        System.out.println("1 random step has an average displacement of " + runSimulation(1));
        for (int i = 2; i <= 50; i++) {
            System.out.println(i + " random steps have an average displacement of " + runSimulation(i));
        }
    }

    public static double runSimulation(int numSteps) {
        double total = 0.0;
        for (int i = 0; i < 10000; i++) {
            total += endingDistance(numSteps);
        }
        return total / 10000;
    }

    public static double endingDistance(int numSteps) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < numSteps; i++) {
            int direction = (int) (Math.random() * 4);
            if (direction == 0) {
                x++;
            } else if (direction == 1) {
                y++;
            } else if (direction == 2) {
                x--;
            } else if (direction == 3) {
                y--;
            }
        }
        return Math.sqrt((x * x) + (y * y));
    }
}
