/*
 *  
 */

package controler.medUpdateServlets;

import data.MedUpdateDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet (name = "MedUpdateDel", urlPatterns = {"/MedUpdateDel"})

public class MedUpdateDel extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));

        MedUpdateDAO dao = new MedUpdateDAO();
        dao.delete(id);
    }
}