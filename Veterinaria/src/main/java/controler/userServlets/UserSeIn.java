/*
 *  
 */
package controler.userServlets;

import data.UserDAO;
import model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "UserSeIn", urlPatterns = {"/UserSeIn"})

public class UserSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        UserDAO dao = new UserDAO();
        ArrayList<User> usr;
        try {
            usr = dao.select();
            rq.getSession().setAttribute("user", usr);
            rp.sendRedirect("/Veterinaria/views/userSe.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(UserSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String id = rq.getParameter("id");
            String pwd = rq.getParameter("pwd");
            String name = rq.getParameter("name");
            String lname1 = rq.getParameter("lname1");
            String lname2 = rq.getParameter("lname2");
            Date bdate = null;
            if (!rq.getParameter("bdate").equals("")) {
                bdate = new Date(df.parse(rq.getParameter("bdate")).getTime());
            }
            String addr = rq.getParameter("addr");
            String tel = rq.getParameter("cel");
            String cel = rq.getParameter("tel");
            String email = rq.getParameter("email");
            String r_acct = rq.getParameter("r_acct");

            UserDAO dao = new UserDAO();
            User usr = new User(id, pwd, name, lname1, lname2, bdate, addr, tel, cel, email, r_acct);

            PrintWriter out = rp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<script>");
            if (dao.insert(usr)) {
                out.println("alert('Usuario agregado con éxito.');");
            } else {
                out.println("alert('Error al agregar usuario!.');");
            }
            out.println("window.location='/Veterinaria/views/userIn.jsp'");
            out.println("</script>");
            out.println("</head>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(UserSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
