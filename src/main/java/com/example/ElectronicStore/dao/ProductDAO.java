package com.example.ElectronicStore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.ElectronicStore.model.Product;

public class ProductDAO {
    private String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=electronic_store";
    private String jdbcUsername = "sa";
    private String jdbcPassword = "123";

    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM products";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                int stockQuantity = rs.getInt("stock_quantity");
                String imageUrl = rs.getString("image_url");
                products.add(new Product(id, name, description, price, category, stockQuantity, imageUrl));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void testConnection() {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
            } else {
                System.out.println("Kết nối đến cơ sở dữ liệu không thành công.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi kết nối: " + e.getMessage());
        }
    }
}
