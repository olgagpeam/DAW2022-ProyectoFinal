/*
 *  
 */

package controler.apptSalonServlets;

import data.ApptSalonDAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ApptSalonDel", urlPatterns = {"/ApptSalonDel"})

public class ApptSalonDel extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));

        ApptSalonDAO dao = new ApptSalonDAO();
        dao.delete(id);
    }
}
