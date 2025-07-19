/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controlador;

/**
 *
 * @author MichBalcazar
 */
import ClaseModeloPojos.ConexionDB;
import ClaseModeloPojos.Producto;
import ServicioControlador.ProductoDao;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ActualizarProducto")
public class ActualizarProducto extends HttpServlet{
    
      @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

          try {
              int id = Integer.parseInt(request.getParameter("id"));
              int cantidad = Integer.parseInt(request.getParameter("cantidad"));
              boolean estatus = Boolean.parseBoolean(request.getParameter("estatus"));
              
              ProductoDao dao = new ProductoDao(ConexionDB.getConexion());
              
              //PRIMERO ACTUALIZAMOS CATIDAD
              boolean cantidadActualizada = dao.actualizarCantidad(id, cantidad);
              
              // despues actualizamos estatus
              boolean estatusActualizado = estatus ? dao.reactivarProducto(id) : dao.darDeBajaProducto(id);
              
              if(cantidadActualizada || estatusActualizado){
                  response.sendRedirect("listarProductos");
                  
              }else{
              response.getWriter().println("No se pudo actualizar producto" );
              }
          }catch (Exception e){
              e.printStackTrace();
              response.getWriter().println("error al actualizar producto" + e.getMessage());
              
}
        }
}
