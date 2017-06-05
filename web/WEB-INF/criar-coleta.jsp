<%-- 
    Document   : criarColeta
    Created on : 30/05/2017, 21:54:26
    Author     : José Flávio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Coleta</title>
    </head>
    <body>
    <center>
        <form action="AdicionaColetaServlet" method="get">
            <h1>Criar Coleta</h1>
            <br>
            <b>Descrição: <input type="text" name="descricao" value="" size="30" /><br>
                <br></b>
            <br>
            <input type="submit" value="Criar" name="cadastrar" />
            <input type="reset" value="Cancelar" name="cancelar" />
    </center>
</form>
</body>
</html>
