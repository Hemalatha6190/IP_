package dao;

import model.CartItem;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    public void addToCart(String productName, double price) {

        try {

            Connection con = DBConnection.getConnection();

            if (con == null) {
                System.out.println("Connection is NULL");
                return;
            }

            System.out.println("Connected to database");

            String sql = "INSERT INTO cart (product_name, price, quantity) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, productName);
            ps.setDouble(2, price);
            ps.setInt(3, 1);

            int result = ps.executeUpdate();

            System.out.println("Rows inserted: " + result);

            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("CART INSERT ERROR");
            e.printStackTrace();
        }
    }

    public List<CartItem> getCartItems() {

        List<CartItem> cart = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            if (con == null) {
                System.out.println("Connection is NULL");
                return cart;
            }

            String sql =
                    "SELECT product_name, price, quantity FROM cart";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String productName =
                        rs.getString("product_name");

                double price =
                        rs.getDouble("price");

                int quantity =
                        rs.getInt("quantity");

                CartItem item =
                        new CartItem(productName, price, quantity);

                cart.add(item);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("CART DISPLAY ERROR");
            e.printStackTrace();
        }

        return cart;
    }
}