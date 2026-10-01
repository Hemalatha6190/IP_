package dao;

import model.Product;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<Product>();

        String sql = "SELECT * FROM products ORDER BY product_id";

        try {

            Connection con = DBConnection.getConnection();

            if (con == null) {
                return products;
            }

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Product product = new Product();

                product.setId(
                        rs.getInt("product_id"));

                product.setName(
                        rs.getString("product_name"));

                product.setCategory(
                        rs.getString("category"));

                product.setPrice(
                        rs.getDouble("price"));

                product.setDescription(
                        rs.getString("description"));

                products.add(product);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return products;
    }
}