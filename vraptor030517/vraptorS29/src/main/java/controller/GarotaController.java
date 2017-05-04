/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import database.GarotaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.inject.Inject;
import model.Garota;

/**
 *
 * @author iapereira
 */
@Controller

public class GarotaController {
    
    
    @Inject
    private Result result;
    @Inject
    private GarotaDAO dao;
    
    @Get
    @Path("/garota/excluir/{id}")
    public void excluir(int id) throws ClassNotFoundException, SQLException{
        dao.excluir(id);
        result.redirectTo(this).listar();
    }
    
    @Path("/")
    public ArrayList<Garota> listar() throws ClassNotFoundException, SQLException{
        //GarotaDAO dao = new GarotaDAO();
        return dao.listar();
    }
    
    @Get
    @Path("/garota/tela_adicionar")
    public void tela_adicionar(){
        
    }
    
    
    @Get
    @Path("/garota/tela_alterar/{id}")
    public void tela_alterar(int id) throws ClassNotFoundException, SQLException{
        result.include("garota", dao.obter(id));
    }
    
    @Post
    @Path("/garota/alterar")
    public void alterar(Garota garota) throws ClassNotFoundException, SQLException{
        System.out.println("============================");
        System.out.println("============================");
        System.out.println(garota.getAltura());
        System.out.println(garota.getApelido());
        System.out.println(garota.getBumbum());
        System.out.println(garota.getId());
        System.out.println(garota.getValor());
        System.out.println("============================");
        System.out.println("============================");
        
        dao.alterar(garota);
        result.redirectTo(this).listar();
    }
    
    @Post
    @Path("/garota/adicionar")
    public void adicionar(Garota garota) throws ClassNotFoundException, SQLException{
        dao.inserir(garota);
        result.redirectTo(this).listar();
    }
}
