import java.util.InputMismatchException;
import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        
        while (!validInput) {
            try {
                System.out.print("Enter the number of terms for Fibonacci series: ");
                int numberOfTerms = scanner.nextInt();
                
                if (numberOfTerms < 1) {
                    throw new IllegalArgumentException("Number of terms must be greater than zero.");
                }
                
                System.out.println("Fibonacci series up to " + numberOfTerms + " terms:");
                printFibonacciSeries(numberOfTerms);
                
                validInput = true; // Input is valid, exit the loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer number of terms.");
                scanner.nextLine(); // Consume the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        scanner.close();
    }
    
    public static void printFibonacciSeries(int n) {
        int firstTerm = 0, secondTerm = 1;
        
        for (int i = 1; i <= n; ++i) {
            System.out.print(firstTerm + " ");

            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }
}
