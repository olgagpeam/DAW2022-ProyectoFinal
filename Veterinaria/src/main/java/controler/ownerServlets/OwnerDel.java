/*
 *  
 */

package controler.ownerServlets;

import data.OwnerDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet (name = "OwnerDel", urlPatterns = {"/OwnerDel"})

public class OwnerDel extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String ine = rq.getParameter("ine");

        OwnerDAO dao = new OwnerDAO();
        dao.delete(ine);
    }
}
