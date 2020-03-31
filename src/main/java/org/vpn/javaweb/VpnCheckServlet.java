/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vpn.javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import vpn.detection.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author karas
 */
@WebServlet(name = "VpnCheckServlet", urlPatterns = {"/vpncheck"})
public class VpnCheckServlet extends HttpServlet {

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
            out.println("<title>Servlet VpnCheckServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VpnCheckServlet at " + request.getContextPath() + "</h1>");
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
       // processRequest(request, response);
     //  respoonse.setContentType("text/html");
       //PrintWriter.out = response.getWriter();
       //String nm =request.getParameter("demo");
       //out.print(nm);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response0
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
         response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       String nm =request.getParameter("ip");
     //  System.out.println("ip");
    // out.println("http://api.vpnblocker.net/v2/{html}/{nm}" );
     
     String ipToLookup = nm;
Boolean isHostingorVPN = new VPNDetection().getResponse(ipToLookup).hostip;

request.setAttribute("isHostingorVPN", isHostingorVPN);
request.setAttribute("ip", nm);
//out.println(isHostingorVPN);
       //out.print(nm);
       //RequestDispatcher ds = request.getRequestDispatcher("result1.jsp");
        //ds.forward(request, response);
      if(isHostingorVPN){
       RequestDispatcher ds = request.getRequestDispatcher("result1.jsp");
        ds.forward(request, response);
       }
       else
       {
           RequestDispatcher ds = request.getRequestDispatcher("result2.jsp");
        ds.forward(request, response);
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
