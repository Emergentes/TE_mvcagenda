<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Nota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Nota> lista = (ArrayList<Nota>) session.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de tareas</h1>
        <a href="Main?op=nuevo">Nueva nota</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Hora</th>
                    <th>Actividad</th>
                    <th>Cumplido</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                if (lista != null){
                    for(Nota n : lista){
                %>
                <tr>
                    <td><%= n.getId() %></td>
                    <td><%= n.getHora() %></td>
                    <td><%= n.getActividad() %></td>
                    <td><%= n.isCumplido() %></td>
                    <td><a href="Main?op=editar&id=<%= n.getId()%>">Editar</a></td>
                    <td><a href="Main?op=eliminar&id=<%= n.getId()%>" onclick="return(confirm('Esta seguro de eliminar?'))">Eliminar</a></td>
                </tr>                
                <%
                    }
                }
                %>

            </tbody>
        </table>

    </body>
</html>
