/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controlador;

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



/**
 *
 * @author MichBalcazar
 */

@WebServlet("/listarProductos")
public class ListarProductosServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        try {
            ProductoDao dao = new ProductoDao(ConexionDB.getConexion());
            List<Producto> productos = dao.obtenerTodos();
            request.setAttribute("productos", productos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listarProductos.jsp");
            dispatcher.forward(request, response);
        }catch(SQLException e){
            e.printStackTrace();
            response.getWriter().println("Error al listar productos" + e.getMessage());
        
        }
    }
    }

 

