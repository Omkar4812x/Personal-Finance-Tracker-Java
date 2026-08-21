import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FinanceService service = new FinanceService();

        int userId = 1;   // Use existing user id

        while (true) {

            System.out.println("\n===== PERSONAL FINANCE TRACKER =====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount: ");
                    double incomeAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter source: ");
                    String source = sc.nextLine();

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String incomeDate = sc.nextLine();

                    service.addIncome(userId, incomeAmount, source, incomeDate);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double expenseAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter description: ");
                    String description = sc.nextLine();

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String expenseDate = sc.nextLine();

                    service.addExpense(userId, expenseAmount, category, description, expenseDate);
                    break;

                case 3:
                    service.showBalance(userId);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}