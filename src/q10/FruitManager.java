package q10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FruitManager {

    // 查询所有水果信息
    public void getAllFruits() {
        String query = "SELECT * FROM fruit_check.tb_fruit";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("ID\tName\tPrice");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getBigDecimal("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 添加水果信息
    public void addFruit(String name, double price) {
        String insert = "INSERT INTO fruit_check.tb_fruit (name, price) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insert)) {

            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.executeUpdate();
            System.out.println("Added fruit: " + name + " with price: " + price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 修改水果信息
    public void updateFruit(int id, String name, double price) {
        String update = "UPDATE fruit_check.tb_fruit SET name = ?, price = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(update)) {

            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Updated fruit ID: " + id + " to name: " + name + " with price: " + price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除水果信息
    public void deleteFruit(int id) {
        String delete = "DELETE FROM fruit_check.tb_fruit WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(delete)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Deleted fruit with ID: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
