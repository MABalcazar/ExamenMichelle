<%-- 
    Document   : listarProductos
    Created on : Jul. 18, 2025, 8:26:42 a.m.
    Author     : MichBalcazar
--%>

<%@page import="ClaseModeloPojos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="ClaseModeloPojos.Producto"%>
<%@page session="true"%>
<%@page import="ClaseModeloPojos.Usuario"%>

<%
    String rol = (String) session.getAttribute("rol");
    List<Producto>productos = (List<Producto>) request.getAttribute("productos");
    
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("index.jsp"); // o a donde tengas tu login
        return;
    }
    int idRol = usuario.getId_rol();
%>



<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Productos</title>
    </head>
    
    <body>
        <h1>Inventario de Productos</h1>
        
        <%
            if(productos !=null && !productos.isEmpty()){
        %>
        
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Cantidad</th>
                <th>Estatus</th>
            </tr>
            <%
               for (Producto p : productos){
                
            %>
            <tr>
                <td><%= p.getId()%></td>
                <td><%= p.getNombre()%></td>
                <td><%= p.getDescripcion()%></td>
                <td><%= p.getCantidad()%></td>
                <td><%= p.getEstatus() ? "Activo" : "Inactivo"%></td>
               <td><%= p.getEstatus() ? "Activo" : "Inactivo"%></td>
               
                    <% if (idRol == 1) { %>
                     <td><a href="EditarProducto?id=<%= p.getId()%>">Editar</a></td>
                    <% } else { %>
                         <td>-</td>
                    <% } %>
            </tr>
            
            <%
                } //cierre del for
            %>
            
        </table>
            
            <%
                } else {
            %>
            <p>No hay productos para mostrar</p>
            
            <%
                }//cierre if-else
            %>
            
       
    </body>
</html>
