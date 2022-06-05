
package br.com.projetocervejaria.dao;

import br.com.projetocervejaria.modelo.Usuario;
import br.com.projetocervejaria.util.ConnectionFactory;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDao implements GenericDao {
    
    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet rs;

    public ClienteDao() {
        
        try { 
            this.conexao=ConnectionFactory.conectar();
            
        }catch(Exception e){
             System.out.println("Erro ao iniciar conexao DB"+ e.getMessage());
        }
    }
   
    
    
    

    @Override
    public Boolean cadastrar(Object object) throws Exception {
        try{
           
            Usuario usuario=(Usuario) object;
             MessageDigest md=MessageDigest.getInstance("SHA-256");
            byte messageDigest[]=md.digest(usuario.getSenhacliente().getBytes("UTF-8"));
            StringBuilder sb=new StringBuilder();
            for(byte b:messageDigest){
                sb.append(String.format("%02X", 0xFF & b));
                
            }
            String senhaHex= sb.toString();
             String sql="insert into usuario(nomecliente, telefonecliente, logincliente, emailcliente, senhacliente) values (?,?,?,?,?)";
         this.stmt= this.conexao.prepareStatement(sql);
         this.stmt.setString(1,usuario.getNomecliente());
         this.stmt.setString(2,usuario.getTelefonecliente());
         this.stmt.setString(3,usuario.getLogincliente());
         this.stmt.setString(4,usuario.getEmailcliente());
         this.stmt.setString(5,senhaHex);
         this.stmt.execute();
         return true;
            
            
        }
    catch(Exception e){
         System.out.println("Erro ao cadastrar clienteDAO "+e.getMessage());
        return false;
    }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }

    @Override
    public List<Object> listar() throws Exception {
         List<Object> lista = new ArrayList<>();
        
        try{
            String sql = "select * from usuario order by codigo";
            this.stmt = this.conexao.prepareStatement(sql);
            this.rs = this.stmt.executeQuery();
            
            while(this.rs.next()){
                
                Usuario usuario = new Usuario();
                
                usuario.setCodigo(this.rs.getInt("codigo"));
                usuario.setNomecliente(this.rs.getString("nomecliente"));
                 usuario.setTelefonecliente(this.rs.getString("telefonecliente"));
                  usuario.setLogincliente(this.rs.getString("logincliente"));
                  usuario.setEmailcliente(this.rs.getString("emailcliente"));
                    usuario.setSenhacliente(this.rs.getString("senhacliente"));
               
                
                lista.add(usuario);
            }
        }catch(Exception e){
            System.out.println("Erro ao listar clienteDAO " + e.getMessage());
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return lista;
    
    }
   
   

    @Override
    public Object carregar(Integer codigo) throws Exception {
         Usuario usuario= new Usuario();
        try{
            String sql="select*from usuario where codigo=?";
            this.stmt=this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, codigo);
            this.rs =this.stmt.executeQuery();
            rs.next();
            usuario.setCodigo(this.rs.getInt("codigo"));
            usuario.setNomecliente(this.rs.getString("nomecliente"));
            usuario.setTelefonecliente(this.rs.getString("telefonecliente"));
            usuario.setLogincliente(this.rs.getString("logincliente"));
            usuario.setEmailcliente(this.rs.getString("emailcliente"));
            usuario.setSenhacliente(this.rs.getString("senhacliente"));
    
        }catch(Exception e){
            System.out.println("Erro ao carregar clicenteDao"+ e.getMessage());
            
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return usuario;
}

    @Override
    public Boolean alterar(Object object) throws Exception {
        try{
            Usuario usuario=(Usuario) object;
            String sql="update usuario set nomecliente=?, telefonecliente=?, logincliente=?, emailcliente=?, senhacliente=? where codigo=?";
            this.stmt=this.conexao.prepareStatement(sql);
            this.stmt.setString(1, usuario.getNomecliente());
            this.stmt.setString(2, usuario.getTelefonecliente());
            this.stmt.setString(3, usuario.getLogincliente());
            this.stmt.setString(4, usuario.getEmailcliente());
            this.stmt.setString(5, usuario.getSenhacliente());
            this.stmt.setInt(6, usuario.getCodigo());
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
            String sql = "delete from usuario where codigo=?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, codigo);
            this.stmt.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir clienteDAO" + e.getMessage());
            return false;
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }
      public Usuario logar(Usuario obj) throws Exception{
        
        Usuario usuario = new Usuario();
        try{
             MessageDigest md=MessageDigest.getInstance("SHA-256");
            byte messageDigest[]=md.digest(obj.getSenhacliente().getBytes("UTF-8"));
            StringBuilder sb=new StringBuilder();
            for(byte b:messageDigest){
                sb.append(String.format("%02X", 0xFF & b));
                
            }
             String senhaHex= sb.toString();
            String sql="select*from usuario where emailcliente=? and senhacliente=?";
            this.stmt=this.conexao.prepareStatement(sql);
            this.stmt.setString(1, obj.getEmailcliente());
            this.stmt.setString(2,senhaHex);
            this.rs=this.stmt.executeQuery();
            
            
            if(this.rs.next()){
                usuario.setCodigo(this.rs.getInt("codigo"));
                usuario.setNomecliente(this.rs.getString("nomecliente"));
                usuario.setEmailcliente(this.rs.getString("emailcliente"));
                usuario.setSenhacliente(this.rs.getString("senhacliente"));
            }
            
            
        }catch(Exception e){
            System.out.println("Erro ao logar clienteDao"+e.getMessage());
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt,rs);
        }
        return usuario;
    }
}
    

