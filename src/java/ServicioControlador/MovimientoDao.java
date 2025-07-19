/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicioControlador;

import ClaseModeloPojos.Movimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

/**
 *
 * @author MichBalcazar
 */
public class MovimientoDao {
    private Connection conn;
    
    //costructor vacio para agregar los datos mas tarde
    public MovimientoDao(Connection conn){
    this.conn = conn;
    }
    
        
    public List<Movimiento> ListarTodos(){
        List<Movimiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM movimientos";
        //ejecutar el SQL con la conexion 
      try {  
        PreparedStatement stmt = conn.prepareStatement(sql);
       // stmt.setInt(1, id_tipo_movimiento); //Primero los parametros
        ResultSet rs = stmt.executeQuery(); //luego se ejecuta
        
        //recorre resultados 
        
      while (rs.next()){
          Movimiento m = new Movimiento();
          m.setId(rs.getInt("id"));
          m.setIdProducto(rs.getInt("id_producto"));
          m.setIdUsuario(rs.getInt("id_usuario"));
          m.setIdTipoMovimiento(rs.getInt("id_tipo_movimiento"));
          m.setCantidad(rs.getInt("cantidad"));
          m.setFecha(rs.getTimestamp("fecha"));
          
 lista.add(m);

    }
   
      }catch(SQLException e){
         System.err.println("Error al obtener los productos" + e.getMessage());
                }
        return lista;
    }
    
    public boolean RegistrarMovimiento(int id_producto, int id_usuario, int id_tipo_movimiento, int cantidad){
          String sql = "INSERT INTO movimientos (id_producto, id_usuario,id_tipo_movimiento, cantidad) VALUES(?, ?, ?, ? )";
    try{
           //insertar datos de manera segura
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_producto);
        stmt.setInt(2, id_usuario);
        stmt.setInt(3, id_tipo_movimiento);
        stmt.setInt(4, cantidad);
        
        int filas = stmt.executeUpdate();
        return filas > 0;
        }catch (SQLException e){
            System.out.println("Error al registrar movimiento" + e.getMessage());
            return false;
        }
    
    }
    public List<String> listarHistorialCompleto(){
        List<String> lista = new ArrayList<>();
        String sql = "SELECT " +
                     "movimientos.id, "+
                     "productos.nombre AS nombre_producto, " +
                     "usuarios.nombre AS nombre_usuario, " +
                     "tipo_movimiento.nombre AS tipo_movimiento, " +
                     "movimientos.cantidad, " +
                     "movimientos.fecha " +
                     "FROM movimientos "+
                     "JOIN productos ON movimientos.id_producto = productos.id " +
                     "JOIN usuarios ON movimientos.id_usuario = usuarios.id " +
                     "JOIN tipo_movimiento ON movimientos.id_tipo_movimiento = tipo_movimiento.id;";
                
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            int id = rs.getInt("id");
            String producto = rs.getString("nombre_producto");
            String usuario = rs.getString("nombre_usuario");
            String tipo = rs.getString("tipo_movimiento");
            int cantidad = rs.getInt("cantidad");
            Timestamp fecha = rs.getTimestamp("fecha");
            
            
            String linea = "ID: " + id + ", Producto: " + producto +
                           ", Usuario: " + usuario + ", Tipo: " + tipo +
                           ", Cantidad: " + cantidad + ", Fecha: " + fecha.toString();
            
            lista.add(linea);
         }
        
    }catch(SQLException e){
        System.err.println("Error al obtener historial: " + e.getMessage());
        
    } 
    return lista;
   }
    public boolean insertar(Movimiento m){
    String sql = "INSERT INTO movimientos (id_producto, id_usuario, id_tipo_movimiento, cantidad) VALUES (?, ?, ?, ?)";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, m.getIdProducto());
        stmt.setInt(2, m.getIdUsuario());
        stmt.setInt(3, m.getIdTipoMovimiento());
        stmt.setInt(4, m.getCantidad());
        return stmt.executeUpdate() > 0;
    } catch(SQLException e){
        System.out.println("Error al insertar movimiento: " + e.getMessage());
        return false;
    }
}
      

    
}
 