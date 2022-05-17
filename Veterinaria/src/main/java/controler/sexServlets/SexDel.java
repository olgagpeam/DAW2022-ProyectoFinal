/*
 *  
 */
package controler.sexServlets;

import data.SexDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "SexDel", urlPatterns = {"/SexDel"})

public class SexDel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String id = rq.getParameter("id");

        SexDAO dao = new SexDAO();
        dao.delete(id);
    }
}
