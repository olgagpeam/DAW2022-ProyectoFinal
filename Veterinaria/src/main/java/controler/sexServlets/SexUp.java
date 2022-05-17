/*
 *  
 */
package controler.sexServlets;

import data.SexDAO;
import model.Sex;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "SexUp", urlPatterns = {"/SexUp"})

public class SexUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        
        String id = rq.getParameter("id");
        String sex = rq.getParameter("sex");

        SexDAO dao = new SexDAO();
        Sex sx = new Sex(sex);
        dao.update(sx, id);
    }
}
