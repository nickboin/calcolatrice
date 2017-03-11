/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.NullPointerException;

/**
 *
 * @author scuola
 */
@WebServlet(name = "Calcolatrice", urlPatterns = {"/Calcolatrice"})
public class Calcolatrice extends HttpServlet {

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
        double operandouno=Double.parseDouble(request.getParameter("num1"));
        double operandodue=Double.parseDouble(request.getParameter("num2"));
        char operazione=request.getParameter("op").charAt(0);
        
        double risultato=calcola(operandouno,operandodue,operazione);
        
        char op;
        switch (operazione) {
            case 'a': op='+';break;
            case 's': op='-';break;
            case 'm': op='*';break;
            case 'd': op='/';break;
            default: op='n';break;
        }
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html><html><head>");
            out.println("<title>Calcolatrice</title></head>");
            out.println("<body> <h1>Calcolatrice</h1>");
            out.println(operandouno+" "+op+" "+operandodue+" = "+risultato);
            out.println("</body></html>");
        }
    }
    
    
    public double calcola(double num1, double num2, char operazione) {
        switch (operazione) {
            case 'a': return num1+num2;
            case 's': return num1-num2;
            case 'm': return num1*num2;
            case 'd': return num1/num2;
            default: return 0;
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