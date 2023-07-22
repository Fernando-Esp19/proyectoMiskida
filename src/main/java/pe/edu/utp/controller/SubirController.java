/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.edu.utp.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.utp.daoImpl.DetalleRecetaDaoImpl;
import pe.edu.utp.daoImpl.PasoDaoImpl;
import pe.edu.utp.dto.DetalleReceta;
import pe.edu.utp.dto.Paso;

/**
 *
 * @author mafer
 */
public class SubirController extends HttpServlet {
    DetalleReceta dr=new DetalleReceta();
    DetalleRecetaDaoImpl drdi=new DetalleRecetaDaoImpl();
    Paso p=new Paso();
    PasoDaoImpl pdi=new PasoDaoImpl();
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SubirController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubirController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
         String nombreRec =request.getParameter("postre");
        System.out.println(nombreRec);
        System.out.println("estoy en el controller");
        // Obtener los datos de las tablas enviados desde el formulario (en formato JSON)
        String datosInsumosJSON = request.getParameter("datos_insumos");
        String datosPasosJSON = request.getParameter("datos_pasos");
        System.out.println(datosInsumosJSON);
        System.out.println("2do dato"+ datosPasosJSON);

        // Convertir los datos de JSON a una lista de objetos DetalleReceta
       
        List<DetalleReceta> listaInsumos = g.fromJson(datosInsumosJSON, new TypeToken<List<DetalleReceta>>(){}.getType());
        List<Paso> listaPasos = g.fromJson(datosPasosJSON, new TypeToken<List<Paso>>(){}.getType());
        System.out.println("aquilista"+listaInsumos);
        System.out.println("2"+listaPasos);
        // Aquí puedes hacer cualquier otra lógica con las listas de DetalleReceta recibidas
        // Por ejemplo, si drdi es un EJB, podrías invocar drdi.create para cada objeto en las listas

        // Ejemplo de invocación para cada objeto en listaInsumos
        for (DetalleReceta insumo : listaInsumos) {
            insumo.setNombre_rec(nombreRec);
            drdi.create(insumo);
        }

        // Ejemplo de invocación para cada objeto en listaPasos
        for (Paso paso : listaPasos) {
            paso.setNombre_rec(nombreRec);
            pdi.create(paso);
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
