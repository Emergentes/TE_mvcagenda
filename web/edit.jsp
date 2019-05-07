<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="reg" scope="request" class="com.emergentes.modelo.Nota" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear nota</h1>
        <form action="Main" method="post">
            ID: <input type="text" name="id" size="2" value="<jsp:getProperty name="reg" property="id" />">
            <br>
            Hora: <input type="text" name="hora" value="<jsp:getProperty name="reg" property="hora" />">
            <br>
            Actividad: <input type="text" name="actividad" value="<jsp:getProperty name="reg" property="actividad" />">
            <br>
            Completado: Si <input type="radio" name="cumplido" value="1" <%= reg.isCumplido() ? "checked" : "" %>> 
                        No <input type="radio" name="cumplido" value="0" <%= !(reg.isCumplido()) ? "checked" : "" %>>
            <br>
            <input type="hidden" name="action" value="2">
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>