<%-- 
    Document   : Login
    Created on : Jul. 17, 2025, 11:56:02 p.m.
    Author     : MichBalcazar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Iniciar Sesion</title>
    </head>
    <body>
        <h2>Login</h2>
        <form action = "LoginServlet" method="post">
            <label for="correo">Correo: </label><br><br>
            <input type="text" id = "correo" name = "correo" required><br><br>
            
            <label for="contrasena">Contrasena:</label>
            <input type="password" id="Contrasena" name="contrasena" required><br><br>
            
            <button type ="submit">Iniciar Sesion</button>
                
            
        </form>
    </body>
</html>
