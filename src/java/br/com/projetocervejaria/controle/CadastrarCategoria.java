/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetocervejaria.controle;

import br.com.projetocervejaria.dao.CategoriaDao;
import br.com.projetocervejaria.dao.GenericDao;
import br.com.projetocervejaria.modelo.Categoria;
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
@WebServlet(name = "CadastrarCategoria", urlPatterns = {"/CadastrarCategoria"})
public class CadastrarCategoria extends HttpServlet {

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
            String codigo=request.getParameter("codigo");
            String nomecategoria=request.getParameter("nomecategoria");
        String descricaocategoria=request.getParameter("descricaocategoria");
        
        Categoria categoria= new Categoria();
        
        categoria.setNomecategoria(nomecategoria);
        categoria.setDescricaocategoria(descricaocategoria);
        
        
        GenericDao dao=new CategoriaDao();
         String mensagem="";
         
         if(codigo.equals("")){
              if(dao.cadastrar(categoria)){
                    mensagem=" foi cadastrado(a) com sucesso!";
                }else{
                    mensagem="Erro ao cadastrar";
                }
             
         }else{
             categoria.setCodigo(Integer.parseInt(codigo));
                if(dao.alterar(categoria)){
                    mensagem="Usuário alterado com sucesso!";
                }else{
                    mensagem="Erro ao alterar usuário";
         }
         }
            
                
                request.setAttribute("msg", mensagem);
                request.getRequestDispatcher("cadastro-categoria.jsp").forward(request, response);
            
            
            
            
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
