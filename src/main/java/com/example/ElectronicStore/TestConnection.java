package com.example.ElectronicStore;

import com.example.ElectronicStore.dao.ProductDAO;

public class TestConnection {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        dao.testConnection();
    }
}
