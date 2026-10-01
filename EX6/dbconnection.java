package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/movie_ticket_system"
                    + "?useSSL=false"
                    + "&allowPublicKeyRetrieval=true"
                    + "&serverTimezone=UTC";

            con = DriverManager.getConnection(
                    url,
                    "root",
                    "Hema003*"
            );

            System.out.println("DATABASE CONNECTED SUCCESSFULLY");

        } catch (Exception e) {

            System.out.println("DATABASE ERROR:");
            e.printStackTrace();
        }

        return con;
    }

    public static void main(String[] args) {

        Connection con = getConnection();

        if (con != null) {
            System.out.println("CONNECTION TEST SUCCESSFUL");
        } else {
            System.out.println("CONNECTION TEST FAILED");
        }
    }
}