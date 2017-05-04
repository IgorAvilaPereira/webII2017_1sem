<%-- 
    Document   : tela_adicionar
    Created on : 03/05/2017, 20:03:41
    Author     : iapereira
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/garota/alterar" method="post">
            Apelido: <input type="text" name="garota.apelido" value="${garota.apelido}">  <br>
            Altura (metros): <input type="text" name="garota.altura" value="<fmt:formatNumber value="${garota.altura}" minFractionDigits="2" type="number"/>">  <br>
            Valor (R$): <input type="text" name="garota.valor" value="<fmt:formatNumber value="${garota.valor}" minFractionDigits="2" type="number"/>">  <br>
            Bumbum (cm): <input type="text" name="garota.bumbum" value="<fmt:formatNumber value="${garota.bumbum}" minFractionDigits="2" type="number"/>"> <br>
            <input type="hidden" name="garota.id" value="${garota.id}">


            <input type="submit">         
        </form>
   </body>
</html>
