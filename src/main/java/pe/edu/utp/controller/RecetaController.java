/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.edu.utp.controller;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.utp.dao.InsumoDao;
import pe.edu.utp.dao.PasoDao;
import pe.edu.utp.dao.RecetaDao;
import pe.edu.utp.daoImpl.InsumoDaoImpl;
import pe.edu.utp.daoImpl.PasoDaoImpl;
import pe.edu.utp.daoImpl.RecetaDaoImpl;

/**
 *
 * @author mafer
 */
public class RecetaController extends HttpServlet {
    RecetaDao r=new RecetaDaoImpl();
    InsumoDao i=new InsumoDaoImpl();
    PasoDao p=new PasoDaoImpl();
    private final Gson g = new Gson();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        PrintWriter out = response.getWriter();
        int op = Integer.parseInt(request.getParameter("opc"));
        
        switch(op){
            case 1:
                out.println(g.toJson(r.readAll()));
                break;
            case 2:
                out.println(g.toJson(r.read(request.getParameter("nombre_rec"))));
                break;
            case 3:
                out.println(g.toJson(i.read(request.getParameter("nombre_rec"))));
                break;
            case 4:
                out.println(g.toJson(p.read(request.getParameter("nombre_rec"))));
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
