/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author iapereira
 */
@SessionScoped
public class Session implements Serializable {
    private int valor;

    public Session() {
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    
}
