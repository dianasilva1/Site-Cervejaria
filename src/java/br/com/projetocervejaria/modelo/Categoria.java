
package br.com.projetocervejaria.modelo;


public class Categoria {
      private Integer codigo;
      private String nomecategoria;
      private String descricaocategoria;

    public Categoria() {
    }

    public Categoria(Integer codigo, String nomecategoria, String descricaocategoria) {
        this.codigo = codigo;
        this.nomecategoria = nomecategoria;
        this.descricaocategoria = descricaocategoria;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomecategoria() {
        return nomecategoria;
    }

    public void setNomecategoria(String nomecategoria) {
        this.nomecategoria = nomecategoria;
    }

    public String getDescricaocategoria() {
        return descricaocategoria;
    }

    public void setDescricaocategoria(String descricaocategoria) {
        this.descricaocategoria = descricaocategoria;
    }
      
    
    
}
