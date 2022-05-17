/*
 *  
 */

package controler.userServlets;

import data.UserDAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "UserDel", urlPatterns = {"/UserDel"})

public class UserDel extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String id = rq.getParameter("id");

        UserDAO dao = new UserDAO();
        dao.delete(id);
    }
}
