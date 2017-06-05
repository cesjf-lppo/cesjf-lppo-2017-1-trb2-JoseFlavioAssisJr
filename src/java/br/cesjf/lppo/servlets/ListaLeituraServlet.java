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
@WebServlet(name = "ListaLeituraServlet", urlPatterns = {"/listar-leituras.html"})
public class ListaLeituraServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Long coleta = null;
        if (request.getParameter("coleta")!=null) {
            coleta = Long.parseLong(request.getParameter("coleta"));
        }
        
        String localLeitura = request.getParameter("localLeitura");
        List<Leitura> leituras;
        
        if(localLeitura==null) {
            try {
                ColetaDAO dao = new ColetaDAO();
                leituras = dao.listaLeituraPorColeta(coleta);
            } catch (Exception ex) {
                leituras = new ArrayList<>();
                Logger.getLogger(ListaLeituraServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("leituras",leituras);
            request.getRequestDispatcher("WEB-INF/listar-leituras.jsp").forward(request, response);
        } else {
            try {
                ColetaDAO dao = new ColetaDAO();
                System.out.println(localLeitura);
                leituras = dao.listaLeituraPorLocal(localLeitura);
            } catch (Exception ex) {
                leituras = new ArrayList<>();
                Logger.getLogger(ListaLeituraServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("leituras",leituras);
            request.getRequestDispatcher("WEB-INF/listar-leituras.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}