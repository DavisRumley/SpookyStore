/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elon.edu.events;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author drumley
 */
@WebServlet(name = "HalloweenServlet", urlPatterns = {"/goelon"})
public class HalloweenServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException{
        doPost(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.html";
        
        String action = request.getParameter("action");
        if(action == null){
            action = "join";
        }
        
        if (action.equals("join")) {
            url = "/index.html";
        }
        
        else if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String zip = request.getParameter("zip");
            
            
            url = "/email_success.html";
        } else {
            url = "/index.html";
        }    
            
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);    
        }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
