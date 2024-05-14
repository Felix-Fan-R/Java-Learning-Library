import javax.swing.*;
import java.sql.*;

public class UserManagement {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Team6GUI";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Yt011017";


    static boolean registerUser(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "用户名和密码不能为空！", "注册失败", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String sqlCheck = "SELECT COUNT(*) FROM users WHERE username = ?";
        String sqlInsert = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement SQLCheck = conn.prepareStatement(sqlCheck);
             PreparedStatement SQLInsert = conn.prepareStatement(sqlInsert)) {

            SQLCheck.setString(1, username);
            ResultSet rs = SQLCheck.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "用户名已存在，请选择其他用户名！", "注册失败", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                // 如果不存在相同的用户名，则插入新用户信息
                SQLInsert.setString(1, username);
                SQLInsert.setString(2, password);
                int rowsAffected = SQLInsert.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    static void forgotPassword() {
        JTextField usernameField = new JTextField();
        Object[] message = {
                "请输入您的用户名:", usernameField
        };
        int option = JOptionPane.showConfirmDialog(null, message, "忘记密码", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = UserManagement.getPassword(username);
            if (password != null) {
                JOptionPane.showMessageDialog(null, "您的密码是：" + password, "密码找回成功", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "未找到对应用户名的密码，请重试！", "密码找回失败", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    static String getPassword(String username) {
        String sql = "SELECT password FROM users WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement SQL = conn.prepareStatement(sql)) {
            SQL.setString(1, username);
            ResultSet rs = SQL.executeQuery();
            if (rs.next()) {
                return rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
