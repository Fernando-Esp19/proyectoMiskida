/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.edu.utp.controller;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import pe.edu.utp.config.Conexion;
import pe.edu.utp.daoImpl.DetalleRecetaDaoImpl;
import pe.edu.utp.daoImpl.InsumoDaoImpl;
import pe.edu.utp.daoImpl.RecetaDaoImpl;
import pe.edu.utp.dto.DetalleReceta;
import pe.edu.utp.dto.Insumo;
import pe.edu.utp.dto.Receta;

/**
 *
 * @author mafer
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10, // 10MB
                 maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AgregarController extends HttpServlet {
    Receta r=new Receta();
    RecetaDaoImpl rdi=new RecetaDaoImpl();
    
    Insumo i=new Insumo();
    InsumoDaoImpl idi=new InsumoDaoImpl();
    
    DetalleReceta dr=new DetalleReceta();
    DetalleRecetaDaoImpl drdi=new DetalleRecetaDaoImpl();
    
    private final Gson g = new Gson();
    private PreparedStatement cst;
    private ResultSet rs;
    private Connection cx;
    
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

        switch (op) {
            case 1: out.println(g.toJson(idi.readAll()));
                    break;
            case 2:
                drdi.create(new DetalleReceta(request.getParameter("nombre_rec"),  request.getParameter("nombre_insumo"),Double.parseDouble(request.getParameter("cantidad")),request.getParameter("unidades")));
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
        
        
 
    
            Part archivoPart = request.getPart("imagen");

            cx = Conexion.getConexion();
            // Crear la sentencia SQL para insertar la imagen
            String sql = "INSERT INTO receta (nombre_rec, imagen) VALUES (?, ?)";
            try (PreparedStatement statement = cx.prepareStatement(sql)) {
                // Establecer los parámetros en la sentencia preparada
                statement.setString(1,request.getParameter("nombrepostre"));
                statement.setBlob(2, archivoPart.getInputStream());
                // Ejecutar la sentencia SQL
                statement.executeUpdate();
                
                String dato = request.getParameter("nombrepostre");

        // Realizar cualquier lógica necesaria con el dato aquí

        // Redireccionar a la página deseada con el dato en la URL
        response.sendRedirect("AgregarInsumoPasos.jsp?dato=" + dato);
            } catch (SQLException ex) {
            Logger.getLogger(AgregarController.class.getName()).log(Level.SEVERE, null, ex);
        }

    
        
        
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
