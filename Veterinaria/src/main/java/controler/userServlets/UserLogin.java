/*
 *  
 */
package controler.userServlets;

import data.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "UserLogin", urlPatterns = {"/UserLogin"})
public class UserLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String id = rq.getParameter("id");
        String pwd = rq.getParameter("pwd");
        UserDAO dao = new UserDAO();
        ArrayList<User> usr;
        try {
            usr = dao.select();
            for (User user : usr) {
                if (user.getId().equals(id) && user.getPwd().equals(pwd)) {
                    //rq.getSession().setAttribute("user", usr);
                    rp.sendRedirect("/Veterinaria/VET.html");
                } else {
                    PrintWriter out = rp.getWriter();
                    /*
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<script>");
                    out.println("alert('Usuario no encontrado.');");
                    out.println("window.location='/Veterinaria/views/log.jsp'");
                    out.println("</script>");
                    out.println("</head>");
                    out.println("</html>");
                     */
                    //rq.getSession().setAttribute("user", usr);
                    rp.sendRedirect("/Veterinaria/views/log.jsp");
                }
            }

        } catch (ParseException ex) {
            Logger.getLogger(UserSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
