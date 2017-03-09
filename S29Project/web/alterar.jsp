<%-- 
    Document   : alterar
    Created on : 08/03/2017, 20:41:00
    Author     : iapereira
--%>

<%@page import="persistencia.GarotaDAO"%>
<%@page import="modelo.Garota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%
            Garota garota = new Garota();
            garota.setId(Integer.parseInt(request.getParameter("id")));
            garota.setApelido(request.getParameter("apelido"));
            garota.setBumbum(Double.valueOf(request.getParameter("bumbum")));
            garota.setAltura(Double.valueOf(request.getParameter("altura")));
            garota.setValorPorHora(Double.valueOf(request.getParameter("valor")));
            boolean resultado = new GarotaDAO().alterar(garota);
            if (resultado) {
            %>    
            <h1> Foi </h1>           
            <% } else { %>    
            <h1> Nao foi </h1>
            <% } %>    
            <a href ="./index.jsp"> Voltar </a>    </body>
</html>
