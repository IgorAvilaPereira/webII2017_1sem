<%-- 
    Document   : excluir
    Created on : 08/03/2017, 20:19:08
    Author     : iapereira
--%>

<%@page import="persistencia.GarotaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            boolean resultado = new GarotaDAO().excluir(id);
            if (resultado) {
                response.sendRedirect("./index.jsp");
            } else { %>    
        <h1> Nao foi </h1>
        <% }%>    
    </body>
</html>
