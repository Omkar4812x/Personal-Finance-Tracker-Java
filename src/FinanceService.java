public class FinanceService {

    IncomeDAO incomeDAO = new IncomeDAO();
    ExpenceDAO expenseDAO = new ExpenceDAO();

    public void addIncome(int userId, double amount, String source, String date) {
        incomeDAO.addIncome(userId, amount, source, date);
    }

    public void addExpense(int userId, double amount, String category, String description, String date) {
        expenseDAO.addExpense(userId, amount, category, description, date);
    }

    public void showBalance(int userId) {

        double totalIncome = incomeDAO.getTotalIncome(userId);
        double totalExpense = expenseDAO.getTotalExpense(userId);

        double balance = totalIncome - totalExpense;

        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expense: " + totalExpense);
        System.out.println("Current Balance: " + balance);
    }
}