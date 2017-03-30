/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import command.garota.GarotaAlterarCommand;
import command.garota.GarotaTelaAlterarCommand;
import command.garota.GarotaExcluirCommand;
import command.garota.GarotaListarCommand;
import command.garota.GarotaAdicionarCommand;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Garota;
import persistencia.GarotaDAO;

/**
 *
 * @author iapereira
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

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
        String acao = "listar";
        if (request.getParameter("acao") != null) {
            acao = request.getParameter("acao");
        }
        try (PrintWriter out = response.getWriter()) {
            if (acao.equals("adicionar")) {
                new GarotaAdicionarCommand().executa(request, response);
            } else if (acao.equals("listar")) {
                new GarotaListarCommand().executa(request, response);
            } else if (acao.equals("excluir")){
                new GarotaExcluirCommand().executa(request, response);                
            } else if (acao.equals("tela_alterar")){
                new GarotaTelaAlterarCommand().executa(request, response);                
            } else if (acao.equals("alterar")){
                new GarotaAlterarCommand().executa(request, response);                
            } 
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