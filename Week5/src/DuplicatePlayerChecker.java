public class DuplicatePlayerChecker {

    public static String findDuplicatePick(String[] playerNames) {
        // Outer loop iterates through each player name
        for (int i = 0; i < playerNames.length; i++) {
            // Inner loop compares with names that come after the current name
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    // Early exit upon finding the first duplicate
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        // Return when no duplicates exist
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Example 1: Contains a duplicate
        String[] team1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println(findDuplicatePick(team1));
        // Output: "Duplicate Found: Kohli"

        // Example 2: No duplicates
        String[] team2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println(findDuplicatePick(team2));
        // Output: "No Duplicates Found"
    }
}