package Controlador;

import ClaseModeloPojos.Usuario;
import ClaseModeloPojos.ConexionDB;
import ServicioControlador.UsuarioDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        
        
        try{
            Connection conn =  ConexionDB.getConexion();
            UsuarioDao dao = new UsuarioDao(conn);
            Usuario usuario = dao.login(correo, contrasena);
            
            if(usuario != null){
                //guardar en sesion
            HttpSession session = request.getSession();
            session.setAttribute("usuario",usuario);
            
                //redireccionr segun el rol
                switch (usuario.getId_rol()) {
                    case 1 -> //administrador
                        response.sendRedirect("dashboardAdmin.jsp");
                    case 2 -> response.sendRedirect("dashboardAlmacenista.jsp");
                    default -> response.getWriter().println("Rol no reconocido");
                }
            }else{
                response.getWriter().println("Credenciales incorrectas");
                response.sendRedirect("login.jsp?error=1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error en la base de datos" + e.getMessage());
        }
    }
}
