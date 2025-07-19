/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClaseModeloPojos;

/**
 *
 * @author MichBalcazar
 */
public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private boolean estatus;
    
    //constructor   
public Producto(int id,String nombre,String descripcion,int cantidad,boolean estatus){
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.cantidad = cantidad;
    this.estatus = estatus;
    
}

public Producto(){}//costructor vacio

public int getId(){return id;}
public void setId(int id){this.id = id;}

public String getNombre(){return nombre;}
public void setNombre(String nombre){this.nombre = nombre;}

public String getDescripcion(){return descripcion;}
public void setDescripcion(String descripcion){this.descripcion = descripcion;}

public int getCantidad(){return cantidad;}
public void setCantidad(int cantidad){this.cantidad = cantidad;}

public boolean getEstatus(){return estatus;}
public void setEstatus(boolean estatus){this.estatus = estatus;}

    public void setPrecio(double precio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
