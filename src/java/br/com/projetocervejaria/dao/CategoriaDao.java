
package br.com.projetocervejaria.dao;

import br.com.projetocervejaria.modelo.Categoria;
import br.com.projetocervejaria.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDao implements GenericDao{
    
    
    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public CategoriaDao(){
    try { 
            this.conexao=ConnectionFactory.conectar();
            
        }catch(Exception e){
             System.out.println("Erro ao iniciar conexao DB"+ e.getMessage());
        }
}

    @Override
    public Boolean cadastrar(Object object) throws Exception {
        try{
            
            Categoria categoria=(Categoria) object;
            
             
             String sql="insert into categoria(nomecategoria, descricaocategoria) values (?,?)";
             this.stmt= this.conexao.prepareStatement(sql);
             this.stmt.setString(1, categoria.getNomecategoria());
             this.stmt.setString(2, categoria.getDescricaocategoria());
              this.stmt.execute();
         return true;
             
             
        }catch(Exception e){
         System.out.println("Erro ao cadastrar categoriDAO "+e.getMessage());
        return false;
    }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }

    @Override
    public List<Object> listar() throws Exception {
        List<Object> lista = new ArrayList<>();
        
         try{
             
            String sql = "select * from categoria order by codigo";
            this.stmt = this.conexao.prepareStatement(sql);
            this.rs = this.stmt.executeQuery();
            
            while(this.rs.next()){
                Categoria categoria=new Categoria();
            
            categoria.setCodigo(this.rs.getInt("codigo"));
            categoria.setNomecategoria(this.rs.getString("nomecategoria"));
            categoria.setDescricaocategoria(this.rs.getString("descricaocategoria"));
            
            lista.add(categoria);
            
            }
            
         }catch(Exception e){
            System.out.println("Erro ao listar categoriaDAO " + e.getMessage());
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return lista;
    }

    @Override
    public Object carregar(Integer codigo) throws Exception {
        Categoria categoria= new Categoria();
        try{
            String sql="select*from categoria where codigo=?";
            this.stmt=this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, codigo);
            this.rs =this.stmt.executeQuery();
            rs.next();
             categoria.setCodigo(this.rs.getInt("codigo"));
             categoria.setNomecategoria(this.rs.getString("nomecategoria"));
             categoria.setDescricaocategoria(this.rs.getString("descricaocategoria"));
            
            
        }catch(Exception e){
            System.out.println("Erro ao carregar categoriaDao"+ e.getMessage());
            
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return categoria;
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
        try{
            Categoria categoria=(Categoria) object;
             String sql="update categoria set nomecategoria=?, descricaocategoria=?  where codigo=?";
               this.stmt=this.conexao.prepareStatement(sql);
               this.stmt.setString(1, categoria.getNomecategoria());
               this.stmt.setString(2, categoria.getDescricaocategoria());
               this.stmt.setInt(3, categoria.getCodigo());
                 this.stmt.execute();
            
            return true;
            
            
            
        }catch(Exception e){
             System.out.println("Erro ao alterar ClienteDao"+ e.getMessage());
            return false;
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }

    @Override
    public Boolean excluir(Integer codigo) throws Exception {
        try {
            String sql = "delete from categoria where codigo=?";
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

