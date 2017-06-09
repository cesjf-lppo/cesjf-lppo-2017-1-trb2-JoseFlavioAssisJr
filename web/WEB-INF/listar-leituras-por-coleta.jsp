<%-- 
    Document   : listar-leituras
    Created on : 05/06/2017, 15:01:17
    Author     : José Flávio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de leituras por coleta:</title>
    </head>
    <body>
        <center>
        <h1>Lista de leituras por coleta:</h1>
        <table border="1">
            <tr>
                <th>Coleta:</th>
                <th>Local:</th>
                <th>Leitura:</th>
                <th>Unidade:</th>
                <th>Atualização: </th>
            </tr>
            <c:forEach var="leitura" items="${leituras}">
                <tr>
                    <td>${leitura.coleta}</td>
                    <td><a href="lista-por-local.html?local=${leitura.localLeitura}">${leitura.localLeitura}</a></td>
                    <td>${leitura.leitura}</td>
                    <td>${leitura.unidade}</td>
                    <td>${leitura.atualizacao}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="listar-coletas.html">Todas as coletas</a>
        </center>
    </body>
</html>
