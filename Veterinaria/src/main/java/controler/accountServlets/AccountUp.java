/*
 *  
 */
package controler.accountServlets;

import data.AccountDAO;
import model.Account;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "AccountUp", urlPatterns = {"/AccountUp"})

public class AccountUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String id = rq.getParameter("id");
        String typeAcct = rq.getParameter("typeAcct");

        AccountDAO dao = new AccountDAO();
        Account acct = new Account(typeAcct);
        dao.update(acct, id);
    }
}
