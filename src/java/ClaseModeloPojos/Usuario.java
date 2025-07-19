/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClaseModeloPojos;

/**
 *
 * @author MichBalcazar
 */

public class Usuario {
     private int id;
     private String nombre;
     private String correo;
     private String contrasena;
     private int id_rol;

      //constructor
public Usuario (int id, String nombre, String correo, String contrasena,int id_rol) {
      this.id = id;
      this.nombre = nombre;
      this.correo = correo;
      this.contrasena = contrasena;
      this.id_rol = id_rol;
    
 }

public Usuario(){
}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    
    public int getId_rol() { return id_rol; }
    public void setId_rol(int id_rol) { this.id_rol = id_rol; }
  
}
