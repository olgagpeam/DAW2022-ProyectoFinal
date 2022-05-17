/*
 *  
 */

package controler.apptConsultServlets;

import data.ApptConsultDAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ApptConsultDel", urlPatterns = {"/ApptConsultDel"})

public class ApptConsultDel extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));

        ApptConsultDAO dao = new ApptConsultDAO();
        dao.delete(id);
    }
}
