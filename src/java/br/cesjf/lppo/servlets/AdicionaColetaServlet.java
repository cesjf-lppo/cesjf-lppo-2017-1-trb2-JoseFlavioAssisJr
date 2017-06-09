package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.dao.ColetaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José Flávio
 */
@WebServlet(name = "AdicionaColetaServlet", urlPatterns = {"/criar-coleta.html"})
public class AdicionaColetaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/criar-coleta.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Coleta coleta = new Coleta();
        coleta.setDescricao(request.getParameter("descricao"));
        
        
        try{
            ColetaDAO dao = new ColetaDAO();
            dao.cria(coleta);
        } catch(Exception ex){
            System.err.println(ex);
            request.setAttribute("mensagem", ex);
            request.getRequestDispatcher("WEB-INF/criar-leitura.jsp").forward(request, response);
            return;
        }
        
        response.sendRedirect("criar-leitura.html");
        
    }
}