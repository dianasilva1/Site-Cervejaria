
package br.com.projetocervejaria.controle;

import br.com.projetocervejaria.dao.FornecedorDao;
import br.com.projetocervejaria.dao.GenericDao;
import br.com.projetocervejaria.modelo.Fornecedor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HOME
 */
@WebServlet(name = "CadastroFornecedor", urlPatterns = {"/CadastroFornecedor"})
public class CadastroFornecedor extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
            String codigo=request.getParameter("codigo");
            String razaosocial=request.getParameter("razaosocial");
        String cnpjfornecedor=request.getParameter("cnpjfornecedor");
            String telefonefornecedor=request.getParameter("telefonefornecedor");
            String ruafornecedor=request.getParameter("ruafornecedor");
             String numfornecedor=request.getParameter("numfornecedor");
              String cepfornecedor=request.getParameter("cepfornecedor");
            String emailfornecedor=request.getParameter("emailfornecedor");
            String estadofornecedor=request.getParameter("estadofornecedor");
            String cidadefornecedor=request.getParameter("cidadefornecedor");
            Fornecedor fornecedor=new Fornecedor();
            
            fornecedor.setRazaosocial(razaosocial);
            fornecedor.setCnpjfornecedor(cnpjfornecedor);
            fornecedor.setTelefonefornecedor(telefonefornecedor);
            fornecedor.setRuafornecedor(ruafornecedor);
            fornecedor.setNumfornecedor(numfornecedor);
            fornecedor.setCepfornecedor(cepfornecedor);
            fornecedor.setEmailfornecedor(emailfornecedor);
            fornecedor.setEstadofornecedor(estadofornecedor);
            fornecedor.setCidadefornecedor(cidadefornecedor);
            
            GenericDao dao=new FornecedorDao();
             String mensagem="";
             
             if(codigo.equals("")){
                 if(dao.cadastrar(fornecedor)){
                    mensagem=fornecedor.getRazaosocial()+" foi cadastrado(a) com sucesso!";
                }else{
                    mensagem="Erro ao cadastrar";
                }
             }else{
                   fornecedor.setCodigo(Integer.parseInt(codigo));
                if(dao.alterar(fornecedor)){
                    mensagem="Fornecedor alterado com sucesso!";
                }else{
                    mensagem="Erro ao alterar fornecedor";
                }
             }
                 
                request.setAttribute("msg", mensagem);
                request.getRequestDispatcher("cadastro-fornecedores.jsp").forward(request, response);
            
           
        }catch(Exception e){
             System.out.println("Erro ao cadastrar o fornecedorCTR"+e.getMessage());
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
