
package br.com.projetocervejaria.controle;

import br.com.projetocervejaria.dao.ClienteDao;
import br.com.projetocervejaria.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HOME
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            String email=request.getParameter("emailcliente");
            String senha=request.getParameter("senhacliente");
            
            Usuario usuario=new Usuario();
            usuario.setEmailcliente(email);
            usuario.setSenhacliente(senha);
            
            ClienteDao dao=new ClienteDao();
            Usuario usuarioLogado = (Usuario) dao.logar(usuario);
            
            if(usuarioLogado.getCodigo() != null){
                //instancia uma sessao
                HttpSession sessao=request.getSession(true);
                sessao.setAttribute("nomeUsuario", usuarioLogado.getNomecliente());
                sessao.setAttribute("emailUsuario", usuarioLogado.getEmailcliente());
                //deu certo
                request.getRequestDispatcher("paginaInicial.jsp").forward(request, response);
                
            }else{
                //deu errado
                request.setAttribute("msg", "E-mail e/ou senha incorreta!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                
            }
            
        }catch(Exception e){
            System.out.println("Erro ao Logar CTR"+e.getMessage());
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
