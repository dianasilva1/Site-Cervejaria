
package br.com.projetocervejaria.modelo;


public class Usuario {
    private Integer codigo;
    private String nomecliente;
    private String telefonecliente;
    private String emailcliente;
   private String logincliente;
   private String senhacliente;

    public Usuario() {
    }

    public Usuario(Integer codigo, String nomecliente, String telefonecliente, String emailcliente, String logincliente, String senhacliente) {
        this.codigo = codigo;
        this.nomecliente = nomecliente;
        this.telefonecliente = telefonecliente;
        this.emailcliente = emailcliente;
        this.logincliente = logincliente;
        this.senhacliente = senhacliente;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public String getTelefonecliente() {
        return telefonecliente;
    }

    public void setTelefonecliente(String telefonecliente) {
        this.telefonecliente = telefonecliente;
    }

    public String getEmailcliente() {
        return emailcliente;
    }

    public void setEmailcliente(String emailcliente) {
        this.emailcliente = emailcliente;
    }

    public String getLogincliente() {
        return logincliente;
    }

    public void setLogincliente(String logincliente) {
        this.logincliente = logincliente;
    }

    public String getSenhacliente() {
        return senhacliente;
    }

    public void setSenhacliente(String senhacliente) {
        this.senhacliente = senhacliente;
    }
   
   
    
    
}
