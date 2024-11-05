import java.util.*;


public class Knapsack {

    // Function to calculate maximum profit using 0/1 Knapsack Dynamic Programming approach
    public static int knapsack(int capacity, int items, int[] price, int[] wt) {
        int[][] dp = new int[items + 1][capacity + 1];

        // Fill the DP table
        for (int i = 0; i <= items; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    // There's nothing to add to the Knapsack
                    dp[i][j] = 0;
                } else if (wt[i] <= j) {
                    // Choose the maximum between not taking the item or taking it
                    dp[i][j] = Math.max(dp[i - 1][j], price[i] + dp[i - 1][j - wt[i]]);
                } else {
                    // If the item cannot be added, take the previous item's value
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[items][capacity]; // Return the maximum profit
    }

    public static void main(String[] args) {
        int capacity = 10;
        int items = 4;
        int[] price = {0, 3, 3, 2, 9}; // prices of items
        int[] wt = {0, 2, 6, 4, 5};    // weights of items

        int maxProfit = knapsack(capacity, items, price, wt); // Call knapsack function
        System.out.println("Maximum Profit Earned: " + maxProfit);
    }
}
