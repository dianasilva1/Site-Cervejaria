/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HOME
 */
public class Login {
    private String email;
    private double senha;
    //gerar os construtores

    public Login() {
    }
//construtor cheio
    public Login(String email, double senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.equals("")){
            this.email="começa com @";
        }else{
        this.email = email;
        }
    }

    public double getSenha() {
        return senha;
    }

    public void setSenha(double senha) {
       
    }

    void setSenha(String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
