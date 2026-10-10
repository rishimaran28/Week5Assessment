public class TopPerformerTracker {

    public static String findMinMaxSpread(int[] scores) {
        // Initialize min and max with the first element of the array
        int min = scores[0];
        int max = scores[0];

        // Single pass through the array starting from index 1
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;

        // Format output as specified
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(scores));
        // Output: "Min: 33 | Max: 90 | Spread: 57"
    }
}