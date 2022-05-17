/*
 *  
 */
package controler.consultServlets;

import data.ConsultDAO;
import model.Consult;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ConsultUp", urlPatterns = {"/ConsultUp"})

public class ConsultUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));
        String nom = rq.getParameter("cons");

        ConsultDAO dao = new ConsultDAO();
        Consult cons = new Consult(nom);
        dao.update(cons, id);
    }
}
