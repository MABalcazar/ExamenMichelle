/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controlador;

import ClaseModeloPojos.Producto;
import ServicioControlador.ProductoDao;
import ClaseModeloPojos.ConexionDB;

import javax.servlet.Servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
/**
 *
 * @author MichBalcazar
 */
 @WebServlet("/EditarProducto")
public class EditarProducto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
        
        //obtener Id del producto desde la URL
        int id = Integer.parseInt(request.getParameter("id"));
        
        try{
            ProductoDao dao = new ProductoDao(ConexionDB.getConexion());
            Producto producto = dao.obtenerPorId(id);
            
            //rnviar el producto al JSP para editar
            request.setAttribute("producto", producto);
            RequestDispatcher dispatcher = request.getRequestDispatcher("EditarProducto.jsp");
            dispatcher.forward(request, response); // envia peticion y l respuesta al archivo jsp para que se muestre en el navegador
        
        }catch(SQLException e){
            e.printStackTrace();
            response.getWriter().print("Error al obtener producto" + e.getMessage());
            
        }
    }
}
