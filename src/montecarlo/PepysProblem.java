package montecarlo;

public class PepysProblem {
    public static void main(String[] args) {
        probabilityOf(6, 1);
        probabilityOf(12, 2);
    }

    public static boolean rollDice(int numRolls, int minOnes) {
        int ones = 0;
        for (int i = 0; i < numRolls; i++) {
            int roll = (int) (Math.random() * 6) + 1;
            if (roll == 1) {
                ones++;
            }
        }
        return ones >= minOnes;
    }

    public static void probabilityOf(int numRolls, int minOnes) {
        int total = 0;
        for (int i = 0; i < 10000; i++) {
            if (rollDice(numRolls, minOnes)) {
                total++;
            }
        }
        System.out.println("the probability of rolling " + minOnes + " ones by rolling a dice " + numRolls + " times is " + (total/10000.0) * 100 + "%");
    }
}
