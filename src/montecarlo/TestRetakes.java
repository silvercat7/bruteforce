package montecarlo;

public class TestRetakes {
    public static void main(String[] args) {
        int totalNotA = 0;
        for (int i = 0; i < 10000; i++) {
            int score = 0;
            int minScore = Integer.MAX_VALUE;
            int minScoreTwo = Integer.MAX_VALUE - 1;
            for (int j = 0; j < 5; j++) {
                int thisScore = multipleChoiceTest(12, 0.9);
                if (thisScore < minScore) {
                    int temp = minScore;
                    minScore = thisScore;
                    minScoreTwo = temp;
                } else if (thisScore < minScoreTwo) {
                    minScoreTwo = thisScore;
                }
                score += thisScore;
            }
            int retake = multipleChoiceTest(12, 0.9);
            if (retake > minScore) {
                score -= minScore;
                score += retake;
            }
            int retakeTwo = multipleChoiceTest(12, 0.9);
            if (retakeTwo > minScoreTwo) {
                score -= minScoreTwo;
                score += retakeTwo;
            }
            if (score < 51) {
                totalNotA++;
            }
        }
        System.out.println("the A level student did not receive an A overall " + ((totalNotA/10000.0) * 100) + "% of the time");
    }

    public static void notAnA() {
        int notA = 0;
        for (int i = 0; i < 10000; i++) {
            if (multipleChoiceTest(100, 0.85) < 85) {
                notA++;
            }
        }
        System.out.println("the probability of an A student not getting an A on a 100 question test is " + ((notA/10000.0) * 100) + "%");
    }

    public static void yesAnA() {
        for (double i = 0.88; i <= 0.93; i += 0.005) {
            int numAs = 0;
            for (int j = 0; j < 10000; j++) {
                if (multipleChoiceTest(100, i) >= 85) {
                    numAs++;
                }
            }
            System.out.println("a " + (i * 100) + "% probability of getting each question correct results in an A " + ((numAs/10000.0) * 100) + "% of the time");
        }
    }

    public static int multipleChoiceTest(int numQuestions, double probability) {
        int points = 0;
        for (int i = 0; i < numQuestions; i++) {
            int answer = (int) (Math.random() * 100) + 1;
            if (answer <= (probability * 100)) {
                points++;
            }
        }
        return points;
    }

    public static void eighteenQuestionTest() {
        int totalNotA = 0;
        for (int i = 0; i < 10000; i++) {
            int score = 0;
            for (int j = 0; j < 5; j++) {
                score += multipleChoiceTest(18, 0.9);
            }
            if (score < 77) {
                totalNotA++;
            }
        }
        System.out.println("the A level student did not receive an A overall " + ((totalNotA/10000.0) * 100) + "% of the time");
    }

    public static void twelveQuestionTest() {
        int totalNotA = 0;
        for (int i = 0; i < 10000; i++) {
            int score = 0;
            for (int j = 0; j < 5; j++) {
                score += multipleChoiceTest(12, 0.9);
            }
            if (score < 51) {
                totalNotA++;
            }
        }
        System.out.println("the A level student did not receive an A overall " + ((totalNotA/10000.0) * 100) + "% of the time");
    }
}
