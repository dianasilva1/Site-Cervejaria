

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Logar"})
public class Logar extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String emailPadrao="adm@gmail.com";
        String senhaPadrao="123";
        String mensagem="";
        String paginaRetorno="paginaInicial.jsp";
       String email=request.getParameter("email");
       String senha=request.getParameter("senha");
       
       
       if(email.equals(emailPadrao)&& (senha.equals(senhaPadrao))){
           mensagem = "Bem-vindo!!";
           paginaRetorno="paginaInicial.jsp";
           
       }else{
           mensagem = "E-mail ou Senha Incorretos! Tente Novamente";
           paginaRetorno="login.jsp";
           
       }
       request.setAttribute("msg", mensagem);
       request.getRequestDispatcher(paginaRetorno).forward(request, response);
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
