import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Utility {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Team6GUI";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Yt011017";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    public static void makeButton(JButton button) {
        button.setForeground(Color.WHITE);
        button.setOpaque(false);
        button.setBackground(new Color(0, 0, 0, 0));
        button.setBorderPainted(false);
    }

    public static class JPanelWithBackground extends JPanel {
        private final Image backgroundImage;
        public JPanelWithBackground(String fileName) {
            backgroundImage = new ImageIcon(fileName).getImage();
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this);
        }
    }



    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }


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
