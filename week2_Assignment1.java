package com.Studyopedia;
import java.util.Scanner;

public class week2_Assignment1 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        // Program loop to allow multiple task executions without restart
        do {
            displayMenu();
            input = scanner.nextLine();

            // Handling the 'exit' command
            if (input.equalsIgnoreCase("exit")) {
                System.out.println(Constants.EXIT);
                break;
            }

            try {
                int taskSelection = Integer.parseInt(input);
                switch (taskSelection) {
                    case 1:
                        generateValidParentheses(scanner);
                        break;
                    case 2:
                        calculateDigitSum(scanner);
                        break;
                    default:
                        System.out.println(Errors.INVALIDTASKNUMBER);
                }
            } catch (NumberFormatException e) {
                System.out.println(Errors.INPUTERROR);
            }

        } while (!input.equalsIgnoreCase("exit"));

        scanner.close();
    }

    // Display available tasks
    private static void displayMenu() {
        System.out.println(Constants.INDEX);
        System.out.println(Constants.TASKNUMBER);
    }

    // Task 1: Generate all valid combinations of parentheses
    private static void generateValidParentheses(Scanner scanner) {
        System.out.println(Constants.TASK1EXECUTION);
        System.out.println(Constants.TASK1INPUT);
        String input = scanner.nextLine();
        System.out.println("Generated combinations:");
        generateCombinations("", input, 0);
        System.out.println();
    }

    // Recursive method to generate string combinations
    private static void generateCombinations(String current, String input, int start) {
        if (!current.isEmpty()) {
            System.out.print(current + " ");
        }
        for (int i = start; i < input.length(); i++) {
            generateCombinations(current + input.charAt(i), input, i + 1);
        }
    }

    // Task 2: Compute the repeated digit sum of a number
    private static void calculateDigitSum(Scanner scanner) {
        System.out.println(Constants.TASK2EXECUTION);
        System.out.print(Constants.TASK2INPUT);
        
        int number = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        if (number < 0) {
            System.out.println(Constants.PLEASEINPUT);
        } else {
            int result = digitSum(number);
            System.out.println("Output: " + result);
        }
    }

    // Recursively sum digits until a single digit remains
    private static int digitSum(int number) {
        while (number >= 10) {
            number = sumDigits(number);
        }
        return number;
    }

    // Helper method to sum individual digits of a number
    private static int sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
