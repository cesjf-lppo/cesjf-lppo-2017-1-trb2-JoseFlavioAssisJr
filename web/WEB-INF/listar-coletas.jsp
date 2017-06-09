<%-- 
    Document   : listar-coletas
    Created on : 05/06/2017, 15:01:50
    Author     : José Flávio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar coletas</title>
    </head>
    <body>
        <center>
        <h1>Listar Coletas</h1>
        <table border="1">
            <tr>
                <th>Descrição:</th>
                <th>Data:</th>
            </tr>
            <c:forEach var="coleta" items="${coletas}">
                <tr>
                    <td>ID: ${coleta.id}</td>
                    <td>${coleta.descricao}</td>
                    <td>${coleta.dataColeta}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="listar-leituras-por-coleta.html?coleta=${coleta.id}">Listar leitura desta coleta</a><br>
        <a href="criar-leitura.html">Cadastrar novo ponto de leitura</a><br>
        <a href="criar-coleta.html">Nova Coleta</a>
        </center>
    </body>
</html>
