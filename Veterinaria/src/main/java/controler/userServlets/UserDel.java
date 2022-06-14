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
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "UserDel", urlPatterns = {"/UserDel"})

public class UserDel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String id = rq.getParameter("id");

        UserDAO dao = new UserDAO();
        PrintWriter out = rp.getWriter();
        try {
            if (dao.delete(id) == 0) {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Usuario eliminado con éxito.');");
                out.println("window.location='/Veterinaria/views/userDel.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                if (dao.delete(id) == 1) {
                    out.println("alert('El ID ingresado no existe');");
                }
                if (dao.delete(id) == 2) {
                    out.println("alert('Error al eliminar usuario!');");
                }
                out.println("window.location='/Veterinaria/views/userDel.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            }
        } catch (ParseException ex) {
            Logger.getLogger(UserDel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
