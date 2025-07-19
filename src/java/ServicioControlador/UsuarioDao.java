package ServicioControlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import ClaseModeloPojos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author MichBalcazar
 */
public class UsuarioDao {
   private Connection conn;
    
    public UsuarioDao(Connection conn){
    this.conn = conn;
    }
 public Usuario login(String correo, String contrasena){
     String sql = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";
     
     try{
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setString(1,correo);
         stmt.setString(2, contrasena);
         
         ResultSet rs = stmt.executeQuery();
         
         if(rs.next()){
             
               System.out.println("Usuario encontrado en la base de datos:");
    System.out.println("Correo en BD: " + rs.getString("correo"));
    System.out.println("Contraseña en BD: " + rs.getString("contrasena"));
    
             Usuario usuario = new Usuario();
             usuario.setId(rs.getInt("id"));
             usuario.setNombre(rs.getString("nombre"));
             usuario.setCorreo(rs.getString("correo"));
             usuario.setContrasena(rs.getString("contrasena"));
             usuario.setId_rol(rs.getInt("id_rol"));
             
             return usuario;
         
         }
     }catch(SQLException e){
         System.out.println("Error al iniciar la sesion" + e.getMessage());
         
     }return null;
    
    }
}
