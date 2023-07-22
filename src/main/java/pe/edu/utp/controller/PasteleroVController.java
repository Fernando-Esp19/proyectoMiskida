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
import pe.edu.utp.daoImpl.AdministradorDaoImpl;
import pe.edu.utp.daoImpl.PasteleroImpl;
import pe.edu.utp.dto.Administrador;
import pe.edu.utp.dto.Pastelero;

/**
 *
 * @author mafer
 */
public class PasteleroVController extends HttpServlet {
    private PasteleroImpl td = new PasteleroImpl();
    private final Gson g = new Gson();
    private Pastelero p = new Pastelero();
    private Administrador ad = new Administrador();
    private AdministradorDaoImpl adi = new AdministradorDaoImpl();
    int r;
    int ar;

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String accion = request.getParameter("pastelero");
        String menu = request.getParameter("admi");
        if (accion != null && accion.equals("Ingresar como pastelero")) {

            String usuario = request.getParameter("usuario");
            String contra = request.getParameter("contra");
            p.setDnip(usuario);
            p.setContra(contra);
            r = td.validar(p);
            if (r == 1) {
                request.getRequestDispatcher("CalculadoraInsumos.jsp").forward(request, response);
            } else if (r == 0) {
                request.getRequestDispatcher("AgregarReceta.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("Agregar.jsp").forward(request, response);

            }
        } else if (menu != null && menu.equals("Ingresar como administrador")) {
            String usuarioa = request.getParameter("usuario");
            String contraa = request.getParameter("contra");
            ad.setDnia(usuarioa);
            ad.setContraa(contraa);
            ar = adi.validarA(ad);
            if (ar == 1) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (ar == 0) {
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("Agregar.jsp").forward(request, response);

            }
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
