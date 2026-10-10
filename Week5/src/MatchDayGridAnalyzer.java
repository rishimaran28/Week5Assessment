public class MatchDayGridAnalyzer {

    // Helper method: Computes the average run rate for a single match (row)
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int runs : row) {
            sum += runs;
        }

        return sum / row.length;
    }

    // Main classification method: Processes all matches in the grid
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            // Call rowAverage helper method for each row
            double avg = rowAverage(runsPerOver[i]);

            // Classify as "Power Surge" if at or above threshold, otherwise "Normal"
            String classification = (avg >= threshold) ? "Power Surge" : "Normal";

            // Format output string
            result.append("Match ").append(i).append(": ").append(classification);

            // Add separator between matches
            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[][] runsPerOver = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };
        int threshold = 8;

        System.out.println(classifyMatches(runsPerOver, threshold));
        // Output: "Match 0: Normal | Match 1: Power Surge | Match 2: Normal"
    }
}