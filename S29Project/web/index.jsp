<%-- 
    Document   : index
    Created on : 08/03/2017, 19:47:53
    Author     : iapereira
--%>

<%@page import="java.util.ArrayList"%>
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
        <%@include file="./cabecalho.jsp" %>
        
        <form action="./excluir_multiplo.jsp" method="post">
        <table border="1">
            <tr>
                <td>  </td>
                <td> Id </td> 
                <td> Apelido</td>
                <td> Altura </td>
                <td> Bumbum </td>
                <td> Valor </td>
                <td> Excluir </td>
                <td> Alterar </td>
            </tr>       
            <%
                session.setAttribute("parametro1", "Marcos");
                // destroi a sessao..
                //session.invalidate();
                
                ArrayList<Garota> vetGarota = new GarotaDAO().selecionarTodos();
                for (int idx = 0; idx < vetGarota.size(); idx++) {
                    Garota garota = vetGarota.get(idx);
            %>
            <tr>               
                <td> <input type="checkbox" name="id" value="<%= garota.getId()%>"></td>
                <td><%= garota.getId()%></td> 
                <td><%= garota.getApelido()%></td>
                <td><%= garota.getAltura()%></td>
                <td> <%= garota.getBumbum()%> </td>
                <td> <%= garota.getValorPorHora()%> </td>
                <td> <a href="./excluir.jsp?id=<%=garota.getId()%>">Excluir</a></td>
                <td> <a href="./tela_alterar.jsp?id=<%=garota.getId()%>">Alterar</a></td>
            </tr>
            <% }%>
        </table>
        <input type="submit" value="Excluir Multiplo">
        </form>
        <br>
        <a href="./tela_adicionar.jsp">Adicionar</a>
    </body>
</html>
