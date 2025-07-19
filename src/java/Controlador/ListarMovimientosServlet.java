/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controlador;

import ClaseModeloPojos.ConexionDB;
import ClaseModeloPojos.Movimiento;
import ServicioControlador.MovimientoDao;

import javax.servlet.Servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author MichBalcazar
 */
@WebServlet("/ListarMovimientos")
public class ListarMovimientosServlet extends HttpServlet{
    
   @Override
   protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {
 
        
        try{
            MovimientoDao dao = new MovimientoDao(ConexionDB.getConexion());
            List<Movimiento>lista = dao.ListarTodos();
            
            //rnviar el producto al JSP para editar
            request.setAttribute("movimientos", lista);
            RequestDispatcher dispatcher = request.getRequestDispatcher("historial.jsp");
            dispatcher.forward(request, response); // envia peticion y l respuesta al archivo jsp para que se muestre en el navegador
        
        }catch(SQLException e){
            e.printStackTrace();
            response.getWriter().print("Error al listar movimientos" + e.getMessage());
            
        }
    }
}

