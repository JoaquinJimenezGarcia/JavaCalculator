import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("**** Calculator App ****");
        int choice = -1;

        do {
            choice = assignChoice(choice, console);
        } while (choice < 1 || choice > 5);

        if (choice != 5) {
            doCalculate(choice, console);
        } else {
            System.out.println("Thank you for using the calculator");
        }
    }

    private static Integer assignChoice(int choice, Scanner console) {
        showMenu();
        System.out.print("Enter your choice: ");
        try {
            choice = Integer.parseInt(console.nextLine());
            return choice;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number");
        }

        return -1;
    }

    private static void showMenu() {
        System.out.println("""
                1. Add
                2. Subtract
                3. Multiply
                4. Divide
                5. Exit
                """);
    }

    private static void doCalculate(int choice, Scanner console) {
        try {
            System.out.print("Insert first value: ");
            var operator1 = Double.parseDouble(console.nextLine());

            System.out.print("Insert second value: ");
            var operator2 = Double.parseDouble(console.nextLine());

            double result = 0;

            switch (choice){
                case 1 -> result = operator1 + operator2;
                case 2 -> result = operator1 - operator2;
                case 3 -> result = operator1 * operator2;
                case 4 -> result = operator1 / operator2;
            }

            System.out.printf("Result: "+ result);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number");
        }
    }
}
