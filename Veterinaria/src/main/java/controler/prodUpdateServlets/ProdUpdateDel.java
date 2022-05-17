/*
 *  
 */

package controler.prodUpdateServlets;

import data.ProdUpdateDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet (name = "ProdUpdateDel", urlPatterns = {"/ProdUpdateDel"})

public class ProdUpdateDel extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));

        ProdUpdateDAO dao = new ProdUpdateDAO();
        dao.delete(id);
    }
}
