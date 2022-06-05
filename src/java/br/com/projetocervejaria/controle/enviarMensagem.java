/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetocervejaria.controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.mail.SimpleEmail;



/**
 *
 * @author HOME
 */
@WebServlet(name = "enviarMensagem", urlPatterns = {"/enviarMensagem"})
public class enviarMensagem extends HttpServlet {

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
        try{
            String nome=request.getParameter("nome");
             String email=request.getParameter("email");
              String telefone=request.getParameter("telefone");
               String mensagem=request.getParameter("mensagem");
            
               SimpleEmail SimpleEmail=new SimpleEmail();
               
             SimpleEmail.setHostName("smtp-mail.outlook.com");
               SimpleEmail.addTo("casadacerveja94@outlook.com");
               SimpleEmail.setFrom("casadacerveja94@outlook.com");//remetente
               SimpleEmail.setSubject("Contato-Cervejaria");
               
               SimpleEmail.setMsg("Nome "+nome+"\n"+
                                   "Telefone "+telefone+"\n"+
                                   "E-mail: "+email+"\n"+
                                    "Mensagem: "+mensagem);
                                   
               SimpleEmail.setAuthentication("casadacerveja94@outlook.com", "projetoInter1");
               SimpleEmail.setSmtpPort(25);
               SimpleEmail.setSSL(false);
                SimpleEmail.setTLS(true);
                 SimpleEmail.send();
                 
                 request.setAttribute("msg", "Mensagem enviada com sucesso!");
                 request.getRequestDispatcher("pagina-contato.jsp").forward(request, response);
                 
               
               
               
               
        
        }catch(Exception e){
            System.out.println("Erro ao enviar mensagemCTR"+e.getMessage());
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
