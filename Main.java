import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double unitsConsumed = 0;

        try {
            System.out.print("Enter the number of units consumed: ");
            unitsConsumed = scanner.nextDouble();

            if (unitsConsumed < 0) {
                throw new IllegalArgumentException("Units consumed cannot be negative.");
            }

            ElectricityBillCalculator calculator = new ElectricityBillCalculator(unitsConsumed);
            System.out.println("Total bill amount: $" + calculator.getTotalBill());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

