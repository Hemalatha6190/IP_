package dao;

import model.Order;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public boolean saveOrder(Order order) {

        String sql = "INSERT INTO orders "
                + "(customer_name, email, product_name, "
                + "quantity, price, total, address) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            if (con == null) {
                return false;
            }

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, order.getCustomerName());
            ps.setString(2, order.getEmail());
            ps.setString(3, order.getProductName());
            ps.setInt(4, order.getQuantity());
            ps.setDouble(5, order.getPrice());
            ps.setDouble(6, order.getTotal());
            ps.setString(7, order.getAddress());

            int result = ps.executeUpdate();

            ps.close();
            con.close();

            return result > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }


    public List<Order> getAllOrders() {

        List<Order> orders = new ArrayList<Order>();

        String sql =
                "SELECT * FROM orders ORDER BY order_id DESC";

        try {

            Connection con = DBConnection.getConnection();

            if (con == null) {
                return orders;
            }

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Order order = new Order();

                order.setOrderId(
                        rs.getInt("order_id"));

                order.setCustomerName(
                        rs.getString("customer_name"));

                order.setEmail(
                        rs.getString("email"));

                order.setProductName(
                        rs.getString("product_name"));

                order.setQuantity(
                        rs.getInt("quantity"));

                order.setPrice(
                        rs.getDouble("price"));

                order.setTotal(
                        rs.getDouble("total"));

                order.setAddress(
                        rs.getString("address"));

                order.setOrderDate(
                        rs.getString("order_date"));

                orders.add(order);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return orders;
    }
}