/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2inte;

import com.google.gson.Gson;
import com.mycompany.proyecto2inte.Daoimpl.PasteleroImpl;
import com.mycompany.proyecto2inte.Entidades.Pastelero;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JOEL
 */

public class PasteleroTController extends HttpServlet {
    private PasteleroImpl td = new PasteleroImpl();
    private final Gson g = new Gson();
    private Pastelero p = new Pastelero();

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
        int op = Integer.parseInt(request.getParameter("opc"));
System.out.println("op: " + op); // Depuración - Verificar el valor de "opc"
 System.out.println("Id: " + request.getParameter("Id"));
        switch (op) {
            case 1:
                out.println(g.toJson(td.readAll()));
                break;
            case 2:
                out.println(g.toJson(td.read(request.getParameter("Id"))));
                break;
            case 4:
                Pastelero p = new Pastelero(Integer.parseInt(request.getParameter("id")), request.getParameter("nombre"), request.getParameter("dnip"), request.getParameter("telef"), request.getParameter("contra"));
                System.out.println(p);
                td.update(p);

                break;
            case 5:
                td.delete(request.getParameter("Id"));
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
