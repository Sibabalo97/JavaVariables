import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int year;
        try {
            System.out.print("Enter a year to check if it's a leap year: ");
            year = scanner.nextInt();
            
            if (isLeapYear(year)) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid year.");
        } finally {
            scanner.close();
        }
    }
    
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true; // Divisible by 400
                } else {
                    return false; // Divisible by 100 but not by 400
                }
            } else {
                return true; // Divisible by 4 but not by 100
            }
        } else {
            return false; // Not divisible by 4
        }
    }
}
