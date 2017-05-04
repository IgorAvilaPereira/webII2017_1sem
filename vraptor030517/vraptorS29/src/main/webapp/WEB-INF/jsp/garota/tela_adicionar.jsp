<%-- 
    Document   : tela_adicionar
    Created on : 03/05/2017, 20:03:41
    Author     : iapereira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/garota/adicionar" method="post">
            Apelido: <input type="text" name="garota.apelido">  <br>
            Altura (m): <input type="text" name="garota.altura">  <br>
            Valor (R$): <input type="text" name="garota.valor">  <br>
            Bumbum (cm): <input type="text" name="garota.bumbum">  <br>
            <input type="submit">         
        </form>
   </body>
</html>
