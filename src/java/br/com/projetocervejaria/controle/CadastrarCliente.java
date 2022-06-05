
package br.com.projetocervejaria.controle;


import br.com.projetocervejaria.dao.ClienteDao;
import br.com.projetocervejaria.dao.GenericDao;
import br.com.projetocervejaria.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CadastrarCliente", urlPatterns = {"/CadastrarCliente"})
public class CadastrarCliente extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String codigo=request.getParameter("codigo");
            String nomecliente=request.getParameter("nomecliente");
            String telefonecliente=request.getParameter("telefonecliente");
            String logincliente=request.getParameter("logincliente");
            String emailcliente=request.getParameter("emailcliente");
            String senhacliente=request.getParameter("senhacliente");
            
            Usuario usuario=new Usuario();
            
            
           
            usuario.setNomecliente(nomecliente);
            usuario.setTelefonecliente(telefonecliente);
            usuario.setLogincliente(logincliente);
            usuario.setEmailcliente(emailcliente);
            usuario.setSenhacliente(senhacliente);
            GenericDao dao=new ClienteDao();
            String mensagem="";
            
            if(codigo.equals("")){
                if(dao.cadastrar(usuario)){
                    mensagem=usuario.getNomecliente()+" foi cadastrado(a) com sucesso!";
                }else{
                    mensagem="Erro ao cadastrar";
                }
                
            }else{
                 usuario.setCodigo(Integer.parseInt(codigo));
                if(dao.alterar(usuario)){
                    mensagem="Usuário alterado com sucesso!";
                }else{
                    mensagem="Erro ao alterar usuário";
                }
            }
            
                 
                request.setAttribute("msg", mensagem);
                request.getRequestDispatcher("cadastro-cliente.jsp").forward(request, response);
            
            
            
        
        }catch(Exception e){
            System.out.println("Erro ao cadastrar o clienteCTR"+e.getMessage());
            
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
