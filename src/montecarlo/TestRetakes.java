package montecarlo;

public class TestRetakes {
    public static void main(String[] args) {
        notAnA();
    }

    public static void notAnA() {
        int notA = 0;
        for (int i = 0; i < 10000; i++) {
            int score = multipleChoiceTest(100);
            if (score < 85) {
                notA++;
            }
        }
        System.out.println("the probability of an A student not getting an A on a 100 question test is " + ((notA/10000.0) * 100) + "%");
    }

    public static int multipleChoiceTest(int numQuestions) {
        int points = 0;
        for (int i = 0; i < numQuestions; i++) {
            int answer = (int) (Math.random() * 100) + 1;
            if (answer <= 85) {
                points++;
            }
        }
        return points;
    }
}
