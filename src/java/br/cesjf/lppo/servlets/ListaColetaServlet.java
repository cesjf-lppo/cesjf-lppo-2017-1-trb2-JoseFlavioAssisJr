package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.Leitura;
import br.cesjf.lppo.dao.ColetaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José Flávio
 */
@WebServlet(name = "ListaColetaServlet", urlPatterns = {"/listar-coletas.html"})
public class ListaColetaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Coleta> coletas;
         
        try {
            ColetaDAO dao = new ColetaDAO();
            coletas = dao.listAll();
        } catch (Exception ex) {
            Logger.getLogger(ListaColetaServlet.class.getName()).log(Level.SEVERE, null, ex);
            coletas = new ArrayList<>();
            request.setAttribute("mensagem", ex.getLocalizedMessage());
        }
        
        request.setAttribute("coletas" , coletas);
        request.getRequestDispatcher("WEB-INF/listar-coletas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
