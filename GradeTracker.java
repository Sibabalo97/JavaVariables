import java.util.InputMismatchException;
import java.util.Scanner;

public class GradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStudents = 0;

        // Loop until valid input is provided for the number of students
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the number of students: ");
                numStudents = scanner.nextInt();
                if (numStudents <= 0) {
                    throw new IllegalArgumentException("Number of students must be greater than zero.");
                }
                validInput = true; // Input is valid, exit the loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer number of students.");
                scanner.nextLine(); // Consume the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.nextLine(); // Consume newline after integer input

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) { // Loop based on the number of students provided
            System.out.println("\nEnter details for Student " + (i + 1) + ":");

            // Input student name
            System.out.print("Name: ");
            String name = scanner.nextLine();

            // Input grades
            double mathGrade = 0, scienceGrade = 0, englishGrade = 0;
            validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Math Grade: ");
                    mathGrade = scanner.nextDouble();

                    System.out.print("Science Grade: ");
                    scienceGrade = scanner.nextDouble();

                    System.out.print("English Grade: ");
                    englishGrade = scanner.nextDouble();

                    validInput = true; // Input is valid, exit the loop
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input for grades. Please enter numeric values.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }

            scanner.nextLine(); // Consume newline after grades input

            students[i] = new Student(name, mathGrade, scienceGrade, englishGrade);
        }

        // Display student grades
        System.out.println("\nStudent Grades:");
        System.out.println("-----------------------------------------------------");
        System.out.printf("| %-20s | %-10s | %-10s | %-10s |\n", "Name", "Math", "Science", "English");
        System.out.println("-----------------------------------------------------");
        for (Student student : students) {
            System.out.printf("| %-20s | %-10.2f | %-10.2f | %-10.2f |\n",
                    student.getName(), student.getMathGrade(), student.getScienceGrade(), student.getEnglishGrade());
        }
        System.out.println("-----------------------------------------------------");

        scanner.close();
    }
}
