/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClaseModeloPojos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/inventario";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";
    
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public static Connection getConexion() throws SQLException{
     return DriverManager.getConnection(URL,USUARIO,CONTRASENA);
    }
}
