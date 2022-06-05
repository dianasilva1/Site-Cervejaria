
package br.com.projetocervejaria.modelo;


public class Fornecedor {
   private Integer  codigo;
   private String razaosocial;
   private String cnpjfornecedor;
   private String telefonefornecedor;
   private String ruafornecedor;
   private String numfornecedor;
   private String cepfornecedor;
   private String emailfornecedor;
   private String estadofornecedor;
   private String cidadefornecedor;

    public Fornecedor() {
    }

    public Fornecedor(Integer codigo, String razaosocial, String cnpjfornecedor, String telefonefornecedor, String ruafornecedor, String numfornecedor, String cepfornecedor, String emailfornecedor, String estadofornecedor, String cidadefornecedor) {
        this.codigo = codigo;
        this.razaosocial = razaosocial;
        this.cnpjfornecedor = cnpjfornecedor;
        this.telefonefornecedor = telefonefornecedor;
        this.ruafornecedor = ruafornecedor;
        this.numfornecedor = numfornecedor;
        this.cepfornecedor = cepfornecedor;
        this.emailfornecedor = emailfornecedor;
        this.estadofornecedor = estadofornecedor;
        this.cidadefornecedor = cidadefornecedor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getCnpjfornecedor() {
        return cnpjfornecedor;
    }

    public void setCnpjfornecedor(String cnpjfornecedor) {
        this.cnpjfornecedor = cnpjfornecedor;
    }

    public String getTelefonefornecedor() {
        return telefonefornecedor;
    }

    public void setTelefonefornecedor(String telefonefornecedor) {
        this.telefonefornecedor = telefonefornecedor;
    }

    public String getRuafornecedor() {
        return ruafornecedor;
    }

    public void setRuafornecedor(String ruafornecedor) {
        this.ruafornecedor = ruafornecedor;
    }

    public String getNumfornecedor() {
        return numfornecedor;
    }

    public void setNumfornecedor(String numfornecedor) {
        this.numfornecedor = numfornecedor;
    }

    public String getCepfornecedor() {
        return cepfornecedor;
    }

    public void setCepfornecedor(String cepfornecedor) {
        this.cepfornecedor = cepfornecedor;
    }

    public String getEmailfornecedor() {
        return emailfornecedor;
    }

    public void setEmailfornecedor(String emailfornecedor) {
        this.emailfornecedor = emailfornecedor;
    }

    public String getEstadofornecedor() {
        return estadofornecedor;
    }

    public void setEstadofornecedor(String estadofornecedor) {
        this.estadofornecedor = estadofornecedor;
    }

    public String getCidadefornecedor() {
        return cidadefornecedor;
    }

    public void setCidadefornecedor(String cidadefornecedor) {
        this.cidadefornecedor = cidadefornecedor;
    }
   
   
    
}
