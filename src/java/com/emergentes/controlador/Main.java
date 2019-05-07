package com.emergentes.controlador;

import com.emergentes.modelo.Nota;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession ses = request.getSession();
        if (ses.getAttribute("lista") == null) {
            ArrayList<Nota> listaux = new ArrayList<>();
            ses.setAttribute("lista", listaux);
        }        
        ArrayList<Nota> lis = (ArrayList<Nota>) ses.getAttribute("lista");        

        String op = request.getParameter("op");

        if (op == null) {
            response.sendRedirect("tareas.jsp");
        } else if (op.equals("nuevo")){
            response.sendRedirect("nuevo.jsp");
        } else if (op.equals("editar")){
            // Registro que se editara
            int id = Integer.parseInt(request.getParameter("id"));
            // Buscar el objeto que lo contiene
            int pos = posNota(id, request);
            // Obtener el elemento a editar
            Nota n = lis.get(pos);
            
            request.setAttribute("reg", n);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } else if (op.equals("eliminar")){
            int id = Integer.parseInt(request.getParameter("id"));
            // Buscar el objeto que lo contiene
            int pos = posNota(id, request);
            // Obtener el elemento a editar
            lis.remove(pos);
            response.sendRedirect("tareas.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ArrayList<Nota> lis = (ArrayList<Nota>) ses.getAttribute("lista");        
        
        int action = Integer.parseInt(request.getParameter("action"));
        
        // grabar nuevo
        if (action == 1){
            int id = Integer.parseInt(request.getParameter("id"));
            String actividad =  request.getParameter("actividad");
            String hora =  request.getParameter("hora");
            boolean cumpli = false;
            if (request.getParameter("cumplido").equals("1")){
                cumpli = true;
            }
            Nota n = new Nota();
            n.setId(id);
            n.setActividad(actividad);
            n.setHora(hora);
            n.setCumplido(cumpli);
            

            lis.add(n);
            
            response.sendRedirect("tareas.jsp");
        }
        // grabar edicion
        if (action == 2){
            int id = Integer.parseInt(request.getParameter("id"));
            String actividad =  request.getParameter("actividad");
            String hora =  request.getParameter("hora");
            boolean cumpli = false;
            if (request.getParameter("cumplido").equals("1")){
                cumpli = true;
            }
            Nota n = new Nota();
            n.setId(id);
            n.setActividad(actividad);
            n.setHora(hora);
            n.setCumplido(cumpli);
            
            int pos = posNota(id, request);        
            lis.set(pos, n);
            
            response.sendRedirect("tareas.jsp");            
        }
    }
    
    public int posNota(int id, HttpServletRequest request)
    {
        boolean encontrado = false;
        int pos = -1;
        HttpSession ses = request.getSession();
        ArrayList<Nota> lis = (ArrayList<Nota>) ses.getAttribute("lista");
        
        for(Nota n : lis ){
            ++pos;
            if (n.getId() == id){
                encontrado = true;
                break;
            }
        }
        System.out.println(pos);
        if (encontrado){
            return pos;
        }
        else return -1;
    }
}
