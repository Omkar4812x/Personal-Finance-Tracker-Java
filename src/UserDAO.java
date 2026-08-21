import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

public class UserDAO {

    public void createUser(String name, String email) {

        String sql = "INSERT INTO users (name, email, created_date) VALUES (?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setObject(3, LocalDateTime.now());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("User Created Successfully!");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}