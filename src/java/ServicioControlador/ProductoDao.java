/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicioControlador;

import ClaseModeloPojos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MichBalcazar
 */
public class ProductoDao {
    private Connection conn;
    
    public ProductoDao(Connection conn){
    this.conn = conn;
    }
    
    public List<Producto> obtenerTodos(){
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        //ejecutar el SQL con la conexion 
      try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        //recorre resultados y creamos objetos Producto
        
      while (rs.next()){
        Producto p = new Producto();
        p.setId(rs.getInt("id"));
        p.setNombre(rs.getString("nombre"));
        p.setDescripcion(rs.getString("descripcion"));
        p.setCantidad(rs.getInt("cantidad"));
        p.setEstatus(rs.getBoolean("estatus"));
        
        lista.add((p)); //agregamos el producto a la lista
    }
   
      }catch(SQLException e){
         System.err.println("Error al obtener los productos" + e.getMessage());
                }
        return lista;
    }
    
    public boolean agregarProducto(String nombre, String descripcion){
        String sql = "INSERT INTO productos (nombre, descripcion, cantidad, estatus) VALUES(?, ?, 0,TRUE)";
        
       try{
           //insertar datos de manera segura
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, descripcion);
        
        int filas = stmt.executeUpdate();
        return filas > 0;
        }catch (SQLException e){
            System.out.println("Error al agreagar producto" + e.getMessage());
            return false;
        }
    }
    
    public boolean aumentarInventario(int id, int cantidad){
        String sql = "UPDATE productos SET cantidad = cantidad + ? WHERE id = ?";
        
         try{
           //insertar datos de manera segura
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, cantidad);
        stmt.setInt(2, id);
        
        int filas = stmt.executeUpdate();
        return filas > 0;
        }
         catch (SQLException e){
            System.out.println("Error al aumentar la cantidad" + e.getMessage());
            return false;
        }
    } 
    
        
    public boolean darDeBajaProducto(int id){
        String sql = "UPDATE productos SET estatus = false WHERE id = ?";
        
         try{
           //insertar datos de manera segura
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        
        int filas = stmt.executeUpdate();
        return filas > 0;
        }
         catch (SQLException e){
            System.out.println("Error al dar de baja" + e.getMessage());
            return false;
        }
    }
    
        public boolean reactivarProducto(int id){
        String sql = "UPDATE productos SET estatus = true WHERE id = ?";
        
         try{
           //insertar datos de manera segura
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        
        int filas = stmt.executeUpdate();
        return filas > 0;
        }
         catch (SQLException e){
            System.out.println("Error al reactivar producto " + e.getMessage());
            return false;
        }
    }
        
          public boolean disminuirInventario(int id, int cantidadSolicitada){
      
              String consultar = "SELECT cantidad FROM productos WHERE id = ?";
              String actualizar = "UPDATE productos SET cantidad = cantidad - ?";
              
              try{
              PreparedStatement stmt1 = conn.prepareStatement(consultar);
              stmt1.setInt(1, id);
              ResultSet rs = stmt1.executeQuery();
              
              if(rs.next()){
              int cantidadActual = rs.getInt("cantidad");
              
              //evaluar si hay suficiente cantidad 
                  if (cantidadActual >= cantidadSolicitada) {
                      
                      //Actualizamos
                      PreparedStatement stmt2 = conn.prepareStatement(actualizar);
                      stmt2.setInt(1, cantidadSolicitada);
                      stmt2.setInt(2,id);
                      
                      int filas = stmt2.executeUpdate();
                      return filas > 0;

                  }else{
                      System.err.println("");
                      return false;
                  }
              }else{
                  System.out.println("Producto no encontrado");
                  return false;
              }
              }catch(SQLException e){
                   System.err.println("Error al disminuir inventario" + e.getMessage());
              }
  
        return false;       
    } 
          public boolean insertar(Producto producto){
          String sql = "INSERT INTO productos (nombre, descripcion, cantidad, estatus) VALUES (?, ?, 0, true)";
          
            try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            int filas = stmt.executeUpdate();
            return filas > 0;
            
            }catch(SQLException e){
                System.err.println("Error al insertar" + e.getMessage());
                return false;
        }
    }
      
          public Producto obtenerPorId(int id) throws SQLException {
              String sql = "SELECT * FROM productos WHERE id = ?";
              PreparedStatement stmt = conn.prepareStatement(sql);
              stmt.setInt(1, id);
              ResultSet rs = stmt.executeQuery();
              
              if(rs.next()){
                  Producto p = new Producto();
                  p.setId(rs.getInt("id"));
                  p.setNombre(rs.getString("nombre"));
                  p.setDescripcion(rs.getString("descripcion"));
                  p.setCantidad(rs.getInt("cantidad"));
                  p.setEstatus(rs.getBoolean("estatus"));
                  return p;
              
              }
        return null;
          }
         
         public boolean actualizarCantidad(int id, int nuevaCantidad){
             String sql = "UPDATE productos SET cantidad = ? WHERE id = ?";
             
             try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, nuevaCantidad);
            stmt.setInt(2, id);
            int filas = stmt.executeUpdate();
            return filas > 0;
            
            }catch(SQLException e){
                System.err.println("Error al Actualizar Cantidad" + e.getMessage());
                return false;
        }
         }
          
}

    

