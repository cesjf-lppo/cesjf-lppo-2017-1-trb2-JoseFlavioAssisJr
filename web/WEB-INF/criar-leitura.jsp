<%-- 
    Document   : criar-leitura
    Created on : 05/06/2017, 15:00:49
    Author     : José Flávio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar pontos de leitura</title>
    </head>
    <body>
    <center>
        <form method="post">
            <h1>Criar pontos de leitura</h1>
            <br>
            <b>Local: <input type="text" name="localLeitura" value="" size="30" /><br>
            <b>Unidade <input type="text" name="unidade" value="" size="30" /><br>
            </b><br>
            <br>
            <input type="submit" value="Criar" name="cadastrarL" />
            <input type="reset" value="Cancelar" name="cancelarL" />
    </center>
</form>
</body>
</html>