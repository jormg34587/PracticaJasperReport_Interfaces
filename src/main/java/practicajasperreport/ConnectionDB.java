/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicajasperreport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 2DAM
 */
public class ConnectionDB {
    
    private static final String USER = "alumno";
    private static final String PASSWORD = "alumno";
    private static final String SCHEMA = "almacen_interfaces";
    private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/aprendizaje?currentSchema=" + SCHEMA;
    
    public static Connection getConnection() throws SQLException{

        return DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD);
        
    }
     
}
