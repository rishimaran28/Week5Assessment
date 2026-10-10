import java.util.Arrays;

public class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public boolean isInjured() {
        return injured;
    }

    // Rule 1 for established players: qualifies on experience alone if matches >= 10
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Rule 2 for newer players: requires both matches >= 5 AND not injured
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    // Comparable implementation to sort by batting average (fantasy points) descending
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    public static String draftAndRank(Player[] players) {
        // Step 1: Count how many players qualify as draftable
        int draftableCount = 0;
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftableCount++;
            }
        }

        // Step 2: Populate array of draftable players
        Player[] draftablePlayers = new Player[draftableCount];
        int index = 0;
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftablePlayers[index++] = p;
            }
        }

        // Step 3: Sort draftable players using Arrays.sort and Player's compareTo method
        Arrays.sort(draftablePlayers);

        // Step 4: Format output string as "1. Name1 | 2. Name2 | ..."
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftablePlayers.length; i++) {
            sb.append(i + 1).append(". ").append(draftablePlayers[i].getName());
            if (i < draftablePlayers.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
        // Output: "1. Rahul | 2. Virat | 3. Dev"
    }
}