
package br.com.projetocervejaria.dao;

import br.com.projetocervejaria.modelo.Fornecedor;
import br.com.projetocervejaria.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FornecedorDao implements GenericDao {
     private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public FornecedorDao(){
         try { 
            this.conexao=ConnectionFactory.conectar();
            
        }catch(Exception e){
             System.out.println("Erro ao iniciar conexao DB"+ e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {
        
        try{
            Fornecedor fornecedor=(Fornecedor) object;
            
             String sql="insert into fornecedor(razaosocial, cnpjfornecedor, telefonefornecedor, ruafornecedor, numfornecedor, cepfornecedor,"
                     + " emailfornecedor, estadofornecedor, cidadefornecedor) values (?,?,?,?,?,?,?,?,?)";
         this.stmt= this.conexao.prepareStatement(sql);
         this.stmt.setString(1, fornecedor.getRazaosocial());
         this.stmt.setString(2, fornecedor.getCnpjfornecedor());
         this.stmt.setString(3, fornecedor.getTelefonefornecedor());
         this.stmt.setString(4, fornecedor.getRuafornecedor());
         this.stmt.setString(5, fornecedor.getNumfornecedor());
         this.stmt.setString(6, fornecedor.getCepfornecedor());
         this.stmt.setString(7, fornecedor.getEmailfornecedor());
         this.stmt.setString(8, fornecedor.getEstadofornecedor());
         this.stmt.setString(9, fornecedor.getCidadefornecedor());
         this.stmt.execute();
         return true;
            
        }catch(Exception e){
             System.out.println("Erro ao cadastrar fornecedorDAO "+e.getMessage());
        return false;
        }finally{
             ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }

    @Override
    public List<Object> listar() throws Exception {
          List<Object> lista = new ArrayList<>();
        
        try{
            String sql = "select * from fornecedor  order by codigo";
            this.stmt = this.conexao.prepareStatement(sql);
            this.rs = this.stmt.executeQuery();
            
            while(this.rs.next()){
            Fornecedor fornecedor=new Fornecedor();
            
            
           fornecedor.setCodigo(this.rs.getInt("codigo"));
           fornecedor.setRazaosocial(this.rs.getString("razaosocial"));
           fornecedor.setCnpjfornecedor(this.rs.getString("cnpjfornecedor"));
           fornecedor.setTelefonefornecedor(this.rs.getString("telefonefornecedor"));
           fornecedor.setRuafornecedor(this.rs.getString("ruafornecedor"));
           fornecedor.setNumfornecedor(this.rs.getString("numfornecedor"));
           fornecedor.setCepfornecedor(this.rs.getString("cepfornecedor"));
           fornecedor.setEmailfornecedor(this.rs.getString("emailfornecedor"));
           fornecedor.setEstadofornecedor(this.rs.getString("estadofornecedor"));
           fornecedor.setCidadefornecedor(this.rs.getString("cidadefornecedor"));
            lista.add(fornecedor);
            }
            
    }catch(Exception e){
            System.out.println("Erro ao listar fornecedorDAO " + e.getMessage());
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return lista;
    
    
    }
   
            
    

    @Override
    public Object carregar(Integer codigo) throws Exception {
       Fornecedor fornecedor=new Fornecedor();
       try{
           String sql="select*from fornecedor where codigo=?";
            this.stmt=this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, codigo);
            this.rs =this.stmt.executeQuery();
            rs.next();
             fornecedor.setCodigo(this.rs.getInt("codigo"));
           fornecedor.setRazaosocial(this.rs.getString("razaosocial"));
           fornecedor.setCnpjfornecedor(this.rs.getString("cnpjfornecedor"));
           fornecedor.setTelefonefornecedor(this.rs.getString("telefonefornecedor"));
           fornecedor.setRuafornecedor(this.rs.getString("ruafornecedor"));
           fornecedor.setNumfornecedor(this.rs.getString("numfornecedor"));
           fornecedor.setCepfornecedor(this.rs.getString("cepfornecedor"));
           fornecedor.setEmailfornecedor(this.rs.getString("emailfornecedor"));
           fornecedor.setEstadofornecedor(this.rs.getString("estadofornecedor"));
           fornecedor.setCidadefornecedor(this.rs.getString("cidadefornecedor"));
           
       }catch(Exception e){
            System.out.println("Erro ao carregar fornecedorDao"+ e.getMessage());
           
       }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
           
       }
       return fornecedor;
       
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
        try{
            Fornecedor fornecedor=(Fornecedor) object;
            String sql="update fornecedor set razaosocial=?, cnpjfornecedor=?, telefonefornecedor=?, emailfornecedor=?, ruafornecedor=?, numfornecedor=?, cepfornecedor=?, estadofornecedor=?, cidadefornecedor=? where codigo=?";
            this.stmt=this.conexao.prepareStatement(sql);
            this.stmt.setString(1, fornecedor.getRazaosocial());
            this.stmt.setString(2, fornecedor.getCnpjfornecedor());
            this.stmt.setString(3, fornecedor.getTelefonefornecedor());
            this.stmt.setString(4, fornecedor.getEmailfornecedor());
            this.stmt.setString(5, fornecedor.getRuafornecedor());
            this.stmt.setString(6, fornecedor.getNumfornecedor());
            this.stmt.setString(7, fornecedor.getCepfornecedor());
            this.stmt.setString(8, fornecedor.getEstadofornecedor());
            this.stmt.setString(9, fornecedor.getCidadefornecedor());
            
            this.stmt.setInt(10, fornecedor.getCodigo());
            this.stmt.execute();
            
            return true;
            
            
        }catch(Exception e){
            System.out.println("Erro ao alterar FornecedorDao"+ e.getMessage());
            return false;
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }

    @Override
    public Boolean excluir(Integer codigo) throws Exception {
         try {
            String sql = "delete from fornecedor where codigo=?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, codigo);
            this.stmt.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir fornecedorDAO" + e.getMessage());
            return false;
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }
    
}
