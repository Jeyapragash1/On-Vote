/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinevoting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JEYAPRAGASH
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/onlinevoting";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinevoting"," root"," root");
            // Now you have a connection to your database
            // You can use this connection to execute SQL queries
            // Don't forget to close the connection when done
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
