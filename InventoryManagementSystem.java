import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Input initial stock levels and threshold for each product
        System.out.println("Enter initial stock levels and threshold for each product:");
        Product[] products = new Product[3]; // Assuming 3 products for demonstration
        for (int i = 0; i < products.length; i++) {
            System.out.print("Product " + (i + 1) + " name: ");
            String name = scanner.nextLine();
            int initialStock = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Initial stock level: ");
                    initialStock = scanner.nextInt();
                    if (initialStock < 0) {
                        throw new IllegalArgumentException("Initial stock level cannot be negative.");
                    }
                    validInput = true; // Input is valid, exit the loop
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for initial stock level.");
                    scanner.nextLine(); // Consume the invalid input
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            scanner.nextLine(); // Consume newline after integer input

            System.out.print("Threshold level: ");
            int threshold = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            products[i] = new Product(name, initialStock, threshold);
        }

        // Simulate sales for each day of the week
        for (int day = 1; day <= 7; day++) {
            System.out.println("\nDay " + day + " - Simulating sales...");
            for (Product product : products) {
                int soldQuantity = random.nextInt(5) + 1; // Randomly sell between 1 to 5 items
                product.sell(soldQuantity);
            }

            // Check for products needing restocking
            for (Product product : products) {
                if (product.needsRestocking()) {
                    System.out.println("Alert: " + product.getName() + " needs restocking! Current stock: " + product.getCurrentStock());
                }
            }
        }

        scanner.close();
    }
}
