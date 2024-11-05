import java.util.Scanner;

public class Fibonacci {

    // Iterative method to count steps for calculating Fibonacci number
    public static int countStepsIterative(int n) {
        if (n <= 1) return 1; // Steps for Fibonacci(0) and Fibonacci(1)

        int a = 0, b = 1;
        int count = 1;

        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
            count++;
        }

        return count; // Return step count
    }

    // Recursive method to count steps for calculating Fibonacci number
    public static int countStepsRecursive(int n) {
        int[] count = {0};
        fib(n, count);
        return count[0]; // Return step count
    }

    // Helper recursive function
    private static int fib(int x, int[] count) {
        count[0]++;
        if (x <= 0) return 0;
        else if (x == 1) return 1;
        else return fib(x - 1, count) + fib(x - 2, count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        System.out.println("Step count (iterative): " + countStepsIterative(n));
        System.out.println("Step count (recursive): " + countStepsRecursive(n));

        scanner.close();
    }
}
