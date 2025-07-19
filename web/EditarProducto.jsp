<%-- 
    Document   : EditarProducto
    Created on : Jul. 18, 2025, 11:32:24 a.m.
    Author     : MichBalcazar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ClaseModeloPojos.Producto" %>
<%@page session="true"%>

<%
    Producto producto = (Producto) request.getAttribute("producto");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Producto</title>
    </head>
 
    <body>
             <form action="ActualizarProducto" method="post">
        <!--ID OCULTO -->
        <input type="hidden" name="id" value="<%= producto.getId()%>" >
        
        <!--Cantidad -->
        <label for="cantidad">Cantidad:</label>
        <input type="number" name="cantidad" value="<%= producto.getCantidad()%>" >

        
        <!--ESTATUS(ACTIVO/INACTIVO) -->
          <label for="estatus">Estatus:</label>
          <select name="estatus">
              <option value="true" <%= producto.getEstatus() ? "selected" : ""%>>Activo</option>
              <option value="false" <%=!producto.getEstatus() ? "selected" : ""%>>Inactivo</option>
          </select><br><br>
        
        <input type="submit" value="Actualizar">
            
    </form>
     
    </body>
</html>
