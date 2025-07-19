/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;
import ClaseModeloPojos.Producto;
import ClaseModeloPojos.ConexionDB;
import ServicioControlador.ProductoDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 *
 * @author MichBalcazar
 */
@WebServlet("/AgregarProducto")
public class AgregarProducto extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        //obtener los datos del formulario
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        
        //crear el objeto producto
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        
        //llamar al DAO para guardar en la base de datos
    
        try {
           ProductoDao dao = new ProductoDao(ConexionDB.getConexion());
           dao.agregarProducto(nombre, descripcion);
           
           response.sendRedirect("dashboardAdmin.jsp");
            
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error en la base de datos: " + e.getMessage());
        }

        
    }
}