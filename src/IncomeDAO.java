import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IncomeDAO {

    public void addIncome(int userId, double amount, String source, String date) {

        String sql = "INSERT INTO income (user_id, amount, source, date) VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setDouble(2, amount);
            ps.setString(3, source);
            ps.setString(4, date);

            ps.executeUpdate();
            System.out.println("Income Added Successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getTotalIncome(int userId) {

        double total = 0;
        String sql = "SELECT SUM(amount) FROM income WHERE user_id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getDouble(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }
}