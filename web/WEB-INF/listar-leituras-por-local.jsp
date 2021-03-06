<%-- 
    Document   : listar-leituras-por-local
    Created on : 05/06/2017, 15:12:09
    Author     : Júnior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de leituras por local:</title>
    </head>
    <body>
        <center>
        <h1>Lista de leituras por local:</h1>
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
                    <td><a href="listar-leituras-por-coleta.html?coleta=">${leitura.coleta}</a></td>
                    <td>${leitura.localLeitura}</td>
                    <td>${leitura.leitura}</td>
                    <td>${leitura.unidade}</td>
                    <td>${leitura.atualizacao}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="listar-coletas.html">Todas as coletas</a>
        </center>
    </body>
</body>
</html>
