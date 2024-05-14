
import java.sql.*;

public class LoginManager {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Team6GUI";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Yt011017";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    public static boolean userLogin(String username, String password) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement SQL = conn.prepareStatement(sql)) {
            SQL.setString(1, username);
            SQL.setString(2, password);
            ResultSet rs = SQL.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean adminLogin(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }
}
