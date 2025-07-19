/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClaseModeloPojos;
import java.sql.Timestamp;

/**
 *
 * @author MichBalcazar
 */
public class Movimiento {
    private int id;
    private int idProducto;
    private int idTipoMovimiento;
    private int idUsuario;
    private int cantidad;
    private Timestamp fecha;
    
 //contructor
        public Movimiento(int id, int idProducto, int idTipoMovimiento, int idUsuario, int cantidad, Timestamp fecha) {
        this.id = id;
        this.idProducto = idProducto;
        this.idTipoMovimiento = idTipoMovimiento;
        this.idUsuario = idUsuario;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
//contructor vacio
    public Movimiento(){
    }
    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public int getIdTipoMovimiento() { return idTipoMovimiento; }
    public void setIdTipoMovimiento(int idTipoMovimiento) { this.idTipoMovimiento = idTipoMovimiento; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public Timestamp getFecha() { return fecha; }
    public void setFecha(Timestamp fecha) { this.fecha = fecha; }
}
