import java.util.*;

class Item {
    int weight, profit;
    double pwRatio;

    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.pwRatio = (double) profit / weight;
    }
}

public class FractionalKnapsack {

    public static double getMaxProfit(List<Item> items, int capacity) {
        items.sort((a, b) -> Double.compare(b.pwRatio, a.pwRatio)); // Sort by profit-to-weight ratio

        double totalProfit = 0;
        for (Item item : items) {
            if (capacity <= 0) break;
            int weightToTake = Math.min(item.weight, capacity);
            totalProfit += weightToTake * item.pwRatio;
            capacity -= weightToTake;
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and profit for item " + (i + 1) + ": ");
            items.add(new Item(scanner.nextInt(), scanner.nextInt()));
        }

        System.out.print("Enter the knapsack capacity: ");
        int capacity = scanner.nextInt();

        System.out.println("Maximum Profit: " + getMaxProfit(items, capacity));
        scanner.close();
    }
}
