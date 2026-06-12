package Task_02;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DecodeLabs_Java_P2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("      STUDENT GRADE CALCULATOR");
        System.out.println("======================================");

        int numberOfSubjects = 0;

        // Input number of subjects
        while (true) {
            try {
                System.out.print("Enter number of subjects: ");
                numberOfSubjects = sc.nextInt();

                if (numberOfSubjects > 0) {
                    break;
                } else {
                    System.out.println("Number of subjects must be greater than 0.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.nextLine();
            }
        }

        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 1; i <= numberOfSubjects; i++) {

            while (true) {
                try {
                    System.out.print("Enter marks for Subject " + i + " (0-100): ");
                    int marks = sc.nextInt();

                    if (marks >= 0 && marks <= 100) {
                        totalMarks += marks;
                        break;
                    } else {
                        System.out.println("Marks must be between 0 and 100.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Enter numeric marks only.");
                    sc.nextLine();
                }
            }
        }

        // Calculate average percentage
        double percentage = (double) totalMarks / numberOfSubjects;

        // Grade Assignment
        char grade;

        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else if (percentage >= 40) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // Pass/Fail Status
        String result = (percentage >= 40) ? "PASS" : "FAIL";

        // Display Result
        System.out.println("\n======================================");
        System.out.println("            RESULT CARD");
        System.out.println("======================================");

        System.out.println("Number of Subjects : " + numberOfSubjects);
        System.out.println("Total Marks        : " + totalMarks + "/" + (numberOfSubjects * 100));
        System.out.printf("Percentage         : %.2f%%\n", percentage);
        System.out.println("Grade              : " + grade);
        System.out.println("Result             : " + result);

        System.out.println("======================================");

        sc.close();
    }
}