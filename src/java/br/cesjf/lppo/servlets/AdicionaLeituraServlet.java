package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Coleta;
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
@WebServlet(name = "AdicionaLeituraServlet", urlPatterns = {"/criar-leitura.html"})
public class AdicionaLeituraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Coleta> coletas = new ArrayList();
        
        try {
            ColetaDAO dao = new ColetaDAO();
            coletas = dao.listAll();
        } catch (Exception ex) {
            Logger.getLogger(AdicionaLeituraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("coletas", coletas);
        request.getRequestDispatcher("WEB-INF/criar-leitura.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Leitura leitura = new Leitura();
        leitura.setColeta(Long.parseLong(request.getParameter("idColeta")));
        leitura.setUnidade(request.getParameter("unidade"));
        leitura.setLocalLeitura(request.getParameter("localLeitura"));
        try {
            ColetaDAO dao = new ColetaDAO();
            dao.criaPontoDeLeitura(leitura);
        } catch (Exception ex) {
            Logger.getLogger(AdicionaLeituraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("listar-coletas.html");
    }
}
