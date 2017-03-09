<%-- 
    Document   : tela_alterar
    Created on : 08/03/2017, 20:34:03
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
        <% Garota garota = new GarotaDAO().obter(Integer.parseInt(request.getParameter("id"))); %>
        
        <form action="./alterar.jsp" method="post">
            Apelido: <input type="text" name="apelido" value="<%=garota.getApelido()%>"> 
            <br>
            Bumbum: <input type="text" name="bumbum" value="<%=garota.getBumbum()%>"> 
            <br>
            Altura: <input type="text" name="altura" value="<%=garota.getAltura()%>"> 
            <br>
            Valor: <input type="text" name="valor" value="<%=garota.getValorPorHora()%>"> 
            <br>
            <input type="hidden" name="id" value="<%=garota.getId()%>">
            
            <input type="submit" value="Alterar">           
        </form>
    </body>
</html>
