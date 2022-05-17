/*
 *  
 */
package controler.accountServlets;

import data.AccountDAO;
import model.Account;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "AccountSeIn", urlPatterns = {"/AccountSeIn"})

public class AccountSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        AccountDAO dao = new AccountDAO();
        ArrayList<Account> acct;
        try {
            acct = dao.select();
            rq.getSession().setAttribute("acct", acct);
            rp.sendRedirect("/Veterinaria/views/AccountConsulta.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(AccountSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            String typeAcct = rq.getParameter("typeAcct");

            AccountDAO dao = new AccountDAO();
            Account acct = new Account(typeAcct);
            dao.insert(acct);
        } catch (ParseException ex) {
            Logger.getLogger(AccountSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
