package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Leitura;
import br.cesjf.lppo.dao.ColetaDAO;
import java.io.IOException;
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
@WebServlet(name = "ListaLeituraPorLocalServlet", urlPatterns = {"/listar-leitura-por-local.html"})
public class ListaLeituraPorLocalServlet extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String local = request.getParameter("local");
        List<Leitura> leituras;
        
        try {
            ColetaDAO dao = new ColetaDAO();
            System.out.println(local);
            leituras = dao.listaLeituraPorLocal(local);
        } catch (Exception ex) {
            leituras = new ArrayList<>();
            Logger.getLogger(ListaLeituraPorLocalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("leituras",leituras);
        request.getRequestDispatcher("/WEB-INF/listar-leituras.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}