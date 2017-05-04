<%-- 
    Document   : listar
    Created on : 03/05/2017, 19:47:36
    Author     : iapereira
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Garotas!</h1>
        <table border ="1">
            <c:forEach items="${garotaList}" var="garota">
                <tr>
                    <td> <a href="${pageContext.request.contextPath}/garota/excluir/${garota.id}">Excluir</a> </td>
                    <td> <a href="${pageContext.request.contextPath}/garota/tela_alterar/${garota.id}">Alterar</a></td> 
                    <td> ${garota.apelido} </td> 
                </tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/garota/tela_adicionar">Adicionar</a>
    </body>
</html>
