<%-- 
    Document   : historial.jsp
    Created on : Jul. 18, 2025, 12:48:38 p.m.
    Author     : MichBalcazar
--%>


<%@page import="ClaseModeloPojos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ClaseModeloPojos.TipoMovimiento"%>
<%@page import="ClaseModeloPojos.Producto"%>
<%@page import="java.util.List"%>
<%@page import="ClaseModeloPojos.Movimiento"%>
<%@page session="true"%>

<%
    List<Movimiento> movimientos = (List<Movimiento>) request.getAttribute("movimientos");
    List<Producto> productos = (List<Producto>)request.getAttribute("productos");
    List<TipoMovimiento> tiposMovimiento = (List<TipoMovimiento>)request.getAttribute("tiposMovimiento");
    Usuario usuario = (Usuario) session.getAttribute("name");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historial de movimientos</title>
    </head>
    <body>
        <h1>Historial de movimientos</h1>
        
        <hr> 
        
        
        <%
            if(movimientos !=null && !movimientos.isEmpty()){
        %>
        
        <table border="1">
            <tr>
                <th>ID</th>
                <th>ID Producto</th>
                <th>ID Usuario</th>
                <th>ID Tipo Movimiento</th>
                <th>ID Cantidad</th>
                <th>Fecha</th>
            </tr>
            <%
            for(Movimiento m : movimientos){
            %>
            <tr>
                <td><%=m.getId()%></td>
                <td><%=m.getIdProducto()%></td>
                <td><%=m.getIdUsuario()%></td>
                <td><%=m.getIdTipoMovimiento()%></td>
                <td><%=m.getCantidad()%></td>
                <td><%=m.getFecha()%></td>
            </tr>
            <%
                }
            %>
            </table>
            
            <%
                }else{
            %>
            
            <p>No hay movimientos registrados</p><!--  -->
              <%
                }
            %>
    </body>
</html>
