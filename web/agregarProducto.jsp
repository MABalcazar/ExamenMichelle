<%-- 
    Document   : index
    Created on : Jul. 17, 2025, 8:54:44 p.m.
    Author     : MichBalcazar
--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Producto</title>
</head>
<body>
    <h1>Formulario para agregar producto</h1>
    <form action="AgregarProducto" method="post">
        <label for="nombre">Nombre del producto:</label>
        <input type="text" name="nombre" id="nombre" required><br><br>

        <label for="descripcion">Descripción:</label>
        <input type="text" name="descripcion" id="descripcion" required><br><br>

        <input type="submit" value="Guardar producto">
    </form>
</body>
</html>

