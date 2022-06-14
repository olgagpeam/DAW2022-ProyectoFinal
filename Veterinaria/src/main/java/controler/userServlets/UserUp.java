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
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "UserUp", urlPatterns = {"/UserUp"})

public class UserUp extends HttpServlet {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        UserDAO dao = new UserDAO();
        ArrayList<User> user;
        try {
            String id = rq.getParameter("id");
            user = dao.select();
            String[] result = {"", "", "", "", "", "", "", "", "", "", ""};

            PrintWriter out = rp.getWriter();
            for (User usr : user) {
                if (usr.getId().equals(id)) {
                    result[0] = usr.getName();
                    result[1] = usr.getLname1();
                    result[2] = usr.getLname2();
                    Date bdate = null;
                    result[3] = null;
                    if (usr.getBdate() != null) {
                        bdate = new Date(df.parse(usr.getBdate().toString()).getTime());
                        result[3] = bdate.toString();
                    }
                    result[4] = usr.getAddr();
                    result[5] = usr.getCel();
                    result[6] = usr.getTel();
                    result[7] = usr.getEmail();
                    result[8] = usr.getR_acct();
                    result[9] = id;
                    result[10] = usr.getPwd();
                    rq.getSession().setAttribute("result", result);
                    rp.sendRedirect("/Veterinaria/views/userSearch.jsp");
                } else {
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<script>");
                    out.println("alert('Usuario no encontrado/ID equivocado!.');");
                    out.println("window.location='/Veterinaria/views/userUp.jsp'");
                    out.println("</script>");
                    out.println("</head>");
                    out.println("</html>");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(UserUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
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
            User usr = new User(pwd, name, lname1, lname2, bdate, addr, tel, cel, email, r_acct);
            
            PrintWriter out = rp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<script>");
            if (dao.update(usr, id)) {
                out.println("alert('Usuario actualizado con éxito.');");
            } else {
                out.println("alert('Error al actualizar usuario!.');");
            }
            out.println("window.location='/Veterinaria/views/userUp.jsp'");
            out.println("</script>");
            out.println("</head>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(UserUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
