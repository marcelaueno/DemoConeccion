package com.mud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Connection conexion = null;

        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // hace referencia a libreria
        conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/base_book",
                "root", "Lionel2021.");
        }catch (ClassNotFoundException exception) {
            exception.getStackTrace();
        }catch (SQLException ex) {
            ex.getStackTrace();
        }
        String queryInsert = "INSERT INTO book(nameBook, anio) VALUES (?,?);";
        PreparedStatement sentencia = null;

        try {
            sentencia = conexion.prepareStatement(queryInsert);
            sentencia.setString(1,"libro33");
            sentencia.setString(2,"2010");
            sentencia.executeUpdate();
        }catch (SQLException ex) {
            ex.getStackTrace();
        }
    }
}
