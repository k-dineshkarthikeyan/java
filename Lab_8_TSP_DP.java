import java.util.Arrays;

public class Lab_8_TSP_DP {
    public static void main(String[] args) {
        int[][] distances = {
                { 0, 9, 13, 12 },
                { 14, 0, 25, 27 },
                { 12, 20, 0, 15 },
                { 13, 17, 27, 0 }
        };
        System.out.println("Optimal distance is " + solveTSP(distances));
    }

    static int[][] distanceMatrix;
    static int numCities;

    static int calculateTourDistance(int[][] dp, int visit, int current) {
        if (visit == (1 << numCities) - 1)
            return distanceMatrix[current][0];
        if (dp[visit][current] != -1)
            return dp[visit][current];
        int minDistance = Integer.MAX_VALUE;
        for (int city = 0; city < numCities; city++)
            if ((visit & (1 << city)) == 0) {
                int newDistance = distanceMatrix[current][city] + calculateTourDistance(dp, visit | (1 << city), city);
                minDistance = Math.min(minDistance, newDistance);
            }
        dp[visit][current] = minDistance;
        return minDistance;
    }

    static int solveTSP(int[][] distances) {
        distanceMatrix = distances;
        numCities = distances.length;
        int[][] dp = new int[1 << numCities][numCities];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        for (int i = 0; i < numCities; i++)
            dp[1 << i][i] = distances[0][i];
        for (int visit = 1; visit < (1 << numCities); visit++)
            for (int current = 0; current < numCities; current++)
                if ((visit & (1 << current)) != 0)
                    for (int next = 0; next < numCities; next++)
                        if ((visit & (1 << next)) == 0) {
                            int newMask = visit | (1 << next);
                            int newDistance = dp[visit][current] + distances[current][next];
                            if (dp[newMask][next] == -1 || newDistance < dp[newMask][next])
                                dp[newMask][next] = newDistance;
                        }
        int minDistance = Integer.MAX_VALUE;
        for (int city = 1; city < numCities; city++) {
            int distance = dp[(1 << numCities) - 1][city] + distances[city][0];
            minDistance = Math.min(minDistance, distance);
        }
        return minDistance;
    }
}