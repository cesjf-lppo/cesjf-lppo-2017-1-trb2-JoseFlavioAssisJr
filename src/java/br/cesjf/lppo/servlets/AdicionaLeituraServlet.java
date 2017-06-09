package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Leitura;
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
@WebServlet(name = "AdicionaLeituraServlet", urlPatterns = {"/criar-leitura.html"})
public class AdicionaLeituraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NumberFormatException {
          
        request.getRequestDispatcher("WEB-INF/criar-leitura.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NumberFormatException {
        Leitura leitura = new Leitura();
        leitura.setColeta(Long.parseLong(request.getParameter("id")));
        leitura.setUnidade(request.getParameter("unidade"));
        leitura.setLocalLeitura(request.getParameter("localLeitura"));
        try {
            ColetaDAO dao = new ColetaDAO();
            dao.criaPontoDeLeitura(leitura);
        } catch (Exception ex) {
            System.err.println(ex);
            request.setAttribute("mensagem", ex);
            request.getRequestDispatcher("WEB-INF/criar-leitura.jsp").forward(request, response);
            return;
        }
        response.sendRedirect("listar-coletas.html");
    }
}
