import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class GarbageManagement {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Team6GUI";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Yt011017";

    static boolean addGarbage(String name, String type) {
        if (name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "添加信息不能为空", "添加失败", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String sql = "INSERT INTO garbage (name, type) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement SQL = conn.prepareStatement(sql)) {
            SQL.setString(1, name);
            SQL.setString(2, type);
            int flag = SQL.executeUpdate();
            return flag > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    static boolean deleteGarbage(Garbage garbage) {
        String sql = "DELETE FROM garbage WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement SQL = conn.prepareStatement(sql)) {
            SQL.setString(1, garbage.getName());
            int flag = SQL.executeUpdate();
            return flag > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    static List<Garbage> getAllGarbage() {
        List<Garbage> garbageList = new ArrayList<>();
        String sql = "SELECT name, type FROM garbage";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                garbageList.add(new Garbage(name, Garbage.GarbageType.valueOf(type)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return garbageList;
    }
    static List<Garbage> queryGarbageFuzzy(String searchText) {
        List<Garbage> garbageList = new ArrayList<>();
        String sql = "SELECT name, type FROM garbage WHERE name LIKE ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + searchText + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                garbageList.add(new Garbage(name, Garbage.GarbageType.valueOf(type)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return garbageList;
    }

//    public static Garbage queryGarbage(String name) {
//        String sql = "SELECT name, type FROM garbage WHERE name = ?";
//        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//             PreparedStatement SQL = conn.prepareStatement(sql)) {
//            SQL.setString(1, name);
//            ResultSet rs = SQL.executeQuery();
//            if (rs.next()) {
//                String garbageName = rs.getString("name");
//                String type = rs.getString("type");
//                return new Garbage(garbageName, Garbage.GarbageType.valueOf(type));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    static List<Garbage> getGarbageByType(String type) {
        List<Garbage> garbageList = new ArrayList<>();
        String sql = "SELECT name, type FROM garbage WHERE type = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                garbageList.add(new Garbage(name, Garbage.GarbageType.valueOf(type)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return garbageList;
    }

}
