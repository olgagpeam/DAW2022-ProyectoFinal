/*
 *  
 */
package controler.userServlets;

import data.UserDAO;
import model.User;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "UserUp", urlPatterns = {"/UserUp"})

public class UserUp extends HttpServlet {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            String id = rq.getParameter("id");
            String name = rq.getParameter("name");
            String lname1 = rq.getParameter("lname1");
            String lname2 = rq.getParameter("lname2");
            Date bdate = new Date(df.parse(rq.getParameter("bdate")).getTime());
            String addr = rq.getParameter("addr");
            String tel = rq.getParameter("cel");
            String cel = rq.getParameter("tel");
            String email = rq.getParameter("email");
            String r_acct = rq.getParameter("r_acct");

            UserDAO dao = new UserDAO();
            User usr = new User(name, lname1, lname2, bdate, addr, tel, cel, email, r_acct);
            dao.update(usr, id);
        } catch (ParseException ex) {
            Logger.getLogger(UserUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
