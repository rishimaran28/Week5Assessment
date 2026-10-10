import java.util.Arrays;

public class FantasyScoreCalculator {

    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        // Multiply captain's score by 2.0 directly in the array
        playerScores[captainIndex] *= 2.0;

        // Multiply vice-captain's score by 1.5 directly in the array
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        // Sample Test Case
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);

        System.out.println(Arrays.toString(scores));
        // Output: [40.0, 110.0, 30.0, 93.0]
    }
}