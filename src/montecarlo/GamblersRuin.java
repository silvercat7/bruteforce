package montecarlo;

public class GamblersRuin {

    public static void main(String[] args) {
        System.out.println(averageBets(50, 250, 10000.0));
    }

    public static String probability(int initialMoney, int goalAmount, double numTrials) {
        int goBig = 0;
        for (int i = 0; i < numTrials; i++) {
            if (gambling(initialMoney, goalAmount) == 250) {
                goBig++;
            }
        }
        return "the probability of ending with $250 is ~" + (goBig / numTrials) * 100 + "%";
    }

    public static int gambling(int initialMoney, int goalAmount) {
        int money = initialMoney;
        while (money > 0 && money < goalAmount) {
            int bet = (int) (Math.random() * 2);
            if (bet == 0) {
                money--;
            } else {
                money++;
            }
        }
        return money;
    }

    public static String averageBets(int initialMoney, int goalAmount, double numTrials) {
        int total = 0;
        for (int i = 0; i < numTrials; i++) {
            total += howManyBets(initialMoney, goalAmount);
        }
        return "the average number of bets needed to reach either $0 or $250 is ~" + (total / numTrials);
    }

    public static int howManyBets(int initialMoney, int goalAmount) {
        int money = initialMoney;
        int numBets = 0;
        while (money > 0 && money < goalAmount) {
            int bet = (int) (Math.random() * 2);
            if (bet == 0) {
                money--;
            } else {
                money++;
            }
            numBets++;
        }
        return numBets;
    }
}
