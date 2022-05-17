/*
 *  
 */
package controler.consultServlets;

import data.ConsultDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ConsultDel", urlPatterns = {"/ConsultDel"})

public class ConsultDel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));

        ConsultDAO dao = new ConsultDAO();
        dao.delete(id);
    }
}
