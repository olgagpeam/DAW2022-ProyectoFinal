/*
 *  
 */
package controler.accountServlets;

import data.AccountDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "AccountDel", urlPatterns = {"/AccountDel"})

public class AccountDel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String id = rq.getParameter("id");

        AccountDAO dao = new AccountDAO();
        dao.delete(id);
    }
}
