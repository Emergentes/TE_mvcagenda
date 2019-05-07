<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear nota</h1>
        <form action="Main" method="post">
            ID: <input type="text" name="id" size="2">
            <br>
            Hora: <input type="text" name="hora">
            <br>
            Actividad: <input type="text" name="actividad">
            <br>
            Completado: Si <input type="radio" name="cumplido" value="1">
            No <input type="radio" name="cumplido" value="0" checked>
            <br>
            <input type="hidden" name="action" value="1">
            <input type="submit" value="Enviar">
                
        </form>
    </body>
</html>
